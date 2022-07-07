package com.endava.BookClub.controller;

import com.endava.BookClub.entity.UserEntity;
import com.endava.BookClub.model.UserToBookToAvailablePeriod;
import com.endava.BookClub.projection.IBooksRentedByASpecificUser;
import com.endava.BookClub.projection.IBorrowerToBookToExpectedReturnTimestamp;
import com.endava.BookClub.service.BookBorrowerService;
import com.endava.BookClub.service.BookService;
import com.endava.BookClub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private  UserService userService;

    @Autowired
    private BookBorrowerService bookBorrowerService;

    @Autowired
    private BookService bookService;

    @PostMapping
    public void createUserAccount(@RequestBody UserEntity user) {
       userService.save(user);
    }

    @PostMapping("rent")
    public void rentBookForPeriod(@RequestBody UserToBookToAvailablePeriod userToBookToAvailablePeriod) {
       bookBorrowerService.rentBookForPeriod(userToBookToAvailablePeriod);
    }

    @PutMapping("rent")
    public void extendRentPeriodForBook(@RequestBody int defaultExtensionPeriodId, @RequestParam int bookId) {
        System.out.println("User Controller - extendRentPeriodForBook");
        // TODO implement
    }

    @GetMapping("own-books/borrowed")
    public List<IBorrowerToBookToExpectedReturnTimestamp> getBooksOfUserBorrowedByOthers(@RequestParam int userId) {
        return bookService.getBooksOfUserBorrowedByOthers(userId);
    }

    @GetMapping("not-owned-books/rented")
    public List<IBooksRentedByASpecificUser> getNotOwnedBooksRentedByMyself(@RequestParam int userId) {
        return bookService.getNotOwnedBooksRentedByMyself(userId);
    }
}
