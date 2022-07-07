package com.endava.BookClub.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class BookBorrowerId implements Serializable {
    private Integer bookId;
    private Integer userId;
    private LocalDateTime expectedReturnTimestamp;
}
