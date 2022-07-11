package com.endava.BookClub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name="book_owner")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(BookOwnerId.class)
public class BookOwnerEntity {
    @Id
    @Column(name = "book_id")
    private Integer bookId;

    @Id
    @Column(name = "user_id")
    private Integer userId;
}
