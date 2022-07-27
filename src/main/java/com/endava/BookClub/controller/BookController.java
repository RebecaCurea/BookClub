package com.endava.BookClub.controller;

import com.endava.BookClub.entity.BookEntity;
import com.endava.BookClub.entity.WaitingListEntity;
import com.endava.BookClub.model.BookToUser;
import com.endava.BookClub.projection.IBookToAvailability;
import com.endava.BookClub.service.BookOwnerService;
import com.endava.BookClub.service.BookService;
import com.endava.BookClub.service.WaitingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookOwnerService bookOwnerService;

    @Autowired
    private WaitingListService waitingListService;

    @PostMapping
    public void addBook(@RequestBody BookToUser bookToUser) {
        bookOwnerService.add(bookToUser);
    }

    @GetMapping("available-for-renting")
    public List<BookEntity> getBooksAvailableForRenting() {
        return bookService.getBooksAvailableForRenting();
    }

    @GetMapping("available-for-renting/{userId}")
    public List<BookEntity> getBooksAvailableForRenting(@PathVariable int userId) {
        return bookService.getBooksAvailableForRenting(userId);
    }

    @GetMapping("search")
    public List<IBookToAvailability> getSearchResult(@RequestParam(value = "title") Optional<String> title, @RequestParam(value = "author") Optional<String> author){
        return  bookService.findByTitleOrAuthor(title, author);
    }

    @PostMapping("waiting-list")
    public void addUserToWaitingListForBook(@RequestBody WaitingListEntity waitingListEntity) {
        System.out.println("Book Controller - waiting list");
        waitingListService.save(waitingListEntity);
    }
}
