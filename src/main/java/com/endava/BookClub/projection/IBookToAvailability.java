package com.endava.BookClub.projection;

import com.endava.BookClub.entity.BookEntity;

import java.time.LocalDateTime;

public interface IBookToAvailability {
    Integer getId();
    String getTitle();
    String getAuthor();
    Integer getPageNr();
    String  getAvailability();
}
