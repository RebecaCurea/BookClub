package com.endava.BookClub.model;

import com.endava.BookClub.entity.BookEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BookToUser {
    private  Integer userId;
    private  BookEntity bookEntity;
}
