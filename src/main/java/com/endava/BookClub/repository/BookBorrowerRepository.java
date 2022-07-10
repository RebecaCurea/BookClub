package com.endava.BookClub.repository;

import com.endava.BookClub.entity.BookBorrowerEntity;
import com.endava.BookClub.entity.BookBorrowerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookBorrowerRepository extends JpaRepository<BookBorrowerEntity, BookBorrowerId> {
    @Query(value="SELECT bb.user_id, bb.book_id, bb.expected_return_timestamp " +
            "FROM book_borrower bb " +
            "WHERE bb.book_id = :bookId AND bb.user_id = :userId", nativeQuery = true)
    List<BookBorrowerEntity> findByBookAndUser(@Param("bookId") Integer bookId, @Param("userId") Integer userId);

    @Modifying
    @Query("" +
            "UPDATE BookBorrowerEntity bb " +
            "SET bb.expectedReturnTimestamp = :timestamp " +
            "WHERE bb.userId = :userId AND bb.bookId = :bookId")
    void updateExpectedReturnTimestamp(
            @Param("timestamp") LocalDateTime timestamp,
            @Param("userId") Integer userId,
            @Param("bookId") Integer bookId);
}