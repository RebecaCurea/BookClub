package com.endava.BookClub.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column(length=50, nullable = false)
    private String title;

    @Column(length=50, nullable = false)
    private String author;

    @Column(name= "page_nr", nullable = false)
    private Integer pageNr;
}
