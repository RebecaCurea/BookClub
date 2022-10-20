package com.endava.BookClub.controller;

import com.endava.BookClub.entity.UserEntity;
import com.endava.BookClub.model.UserToBookToAvailablePeriod;
import com.endava.BookClub.model.BookBorrowerIdToDefaultPeriod;
import com.endava.BookClub.projection.IBooksRentedByASpecificUser;
import com.endava.BookClub.projection.IBorrowerToBookToExpectedReturnTimestamp;
import com.endava.BookClub.service.BookBorrowerService;
import com.endava.BookClub.service.BookService;
import com.endava.BookClub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

//    @PostMapping
//    public void createUserAccount(@RequestBody UserEntity user) {
//       userService.save(user);
//    }

    @PostMapping
    public ResponseEntity<?> createUserAccount(@RequestBody UserEntity user) {
       return userService.save(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public void editUser(@RequestBody UserEntity user, @PathVariable Integer id) {
          userService.editUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserEntity user) {
        return userService.authenticateUser(user);
//        Optional<UserEntity>  optionalUser = userService.findByUsername(user.getUsername());
//
//        if(optionalUser.isPresent()) {
//            if(user.getPassword().equals(optionalUser.get().getPassword())) {
//                return ResponseEntity.ok(optionalUser.get());
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return  userService.getAllUsers();
    }

    @PostMapping("rent")
    public void rentBookForPeriod(@RequestBody UserToBookToAvailablePeriod userToBookToAvailablePeriod) {
        bookBorrowerService.rentBookForPeriod(userToBookToAvailablePeriod);
    }

    @PatchMapping("rent")
    public void extendRentingPeriodForBook(@RequestBody BookBorrowerIdToDefaultPeriod bookBorrowerIdToDefaultPeriod) {
        bookBorrowerService.extendRentingPeriodForBook(bookBorrowerIdToDefaultPeriod);
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
