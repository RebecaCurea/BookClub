package com.endava.BookClub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BookBorrowerId implements Serializable {
    private Integer bookId;
    private Integer userId;
}
