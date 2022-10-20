package com.endava.BookClub.service;

import com.endava.BookClub.entity.BookEntity;
import com.endava.BookClub.projection.IBookToAvailability;
import com.endava.BookClub.projection.IBooksRentedByASpecificUser;
import com.endava.BookClub.projection.IBorrowerToBookToExpectedReturnTimestamp;
import com.endava.BookClub.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<IBookToAvailability> findByTitleOrAuthor(Optional<String> title, Optional<String> author) {
        return bookRepository.findByTitleOrAuthor(title, author);
    }

    public List<BookEntity> getBooksAvailableForRenting() {
        return bookRepository.findBooksAvailableForRenting();
    }

    public List<BookEntity> getBooksAvailableForRenting(int userId) {
        return bookRepository.findBooksAvailableForRenting(userId);
    }

    public List<IBorrowerToBookToExpectedReturnTimestamp> getBooksOfUserBorrowedByOthers(int userId) {
        return bookRepository.getBooksOfUserBorrowedByOthers(userId);
    }

    public List<IBooksRentedByASpecificUser> getNotOwnedBooksRentedByMyself(int userId) {
        return bookRepository.getNotOwnedBooksRentedByMyself(userId);
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookEntity editBook(BookEntity book, Integer id) {
        BookEntity newBook =bookRepository.findById(id).orElseThrow();
        newBook.setAuthor(book.getAuthor());
        newBook.setTitle(book.getTitle());
        newBook.setPageNr(book.getPageNr());
        return bookRepository.save(newBook);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
