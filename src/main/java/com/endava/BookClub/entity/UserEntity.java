package com.endava.BookClub.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.ConnectionBuilder;
import java.util.Set;

@Entity
@Data
@Table(name="users")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

}
