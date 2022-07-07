package com.endava.BookClub.repository;

import com.endava.BookClub.entity.BookBorrowerEntity;
import com.endava.BookClub.entity.BookBorrowerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowerRepository extends JpaRepository<BookBorrowerEntity, BookBorrowerId> {
}