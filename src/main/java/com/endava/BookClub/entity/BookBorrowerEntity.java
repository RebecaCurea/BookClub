package com.endava.BookClub.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name="book_borrower")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(BookBorrowerId.class)
public class BookBorrowerEntity {
    @Id
    @Column(name = "book_id")
    private Integer bookId;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @JsonFormat
    LocalDateTime expectedReturnTimestamp;
}
