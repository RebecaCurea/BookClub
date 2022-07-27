package com.endava.BookClub.service;

import com.endava.BookClub.entity.BookEntity;
import com.endava.BookClub.entity.BookOwnerEntity;
import com.endava.BookClub.model.BookToUser;
import com.endava.BookClub.repository.BookOwnerRepository;
import com.endava.BookClub.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@RequiredArgsConstructor
public class BookOwnerService {
    @Autowired
    private BookOwnerRepository bookOwnerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void add(BookToUser bookToUser) {

        BookEntity book = bookToUser.getBookEntity();
        BookEntity bookEntity = BookEntity
                .builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .pageNr(book.getPageNr())
                .build();
        bookRepository.save(bookEntity);

        BookOwnerEntity bookOwnerEntity = BookOwnerEntity
                .builder()
                .userId(bookToUser.getUserId())
                .bookId(book.getId())
                .build();

        bookOwnerRepository.save(bookOwnerEntity);
    }
}
