package com.endava.BookClub.repository;

import com.endava.BookClub.entity.BookEntity;
import com.endava.BookClub.projection.IBookToAvailability;
import com.endava.BookClub.projection.IBooksRentedByASpecificUser;
import com.endava.BookClub.projection.IBorrowerToBookToExpectedReturnTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository <BookEntity, Integer> {
    @Query( value = "SELECT " +
            "b.id AS id, " +
            "b.title AS title, " +
            "b.author AS author, " +
            "b.page_nr AS pageNr, " +
            "CASE " +
            "WHEN bb.expected_return_timestamp IS NULL OR (bb.expected_return_timestamp IS NOT NULL AND bb.expected_return_timestamp < NOW()) " +
            "THEN CAST (true AS text) ELSE CAST (bb.expected_return_timestamp AS text) " +
            "END AS availability " +
            "FROM books b " +
            "LEFT JOIN book_borrower bb " +
            "ON b.id = bb.book_id " +
            "WHERE (:title <> '' AND :author <> '' AND  b.title = :title AND b.author = :author) OR " +
            "( :title = '' AND :author <> '' AND  b.author = :author) OR " +
            "( :title <> '' AND :author = '' AND  b.title = :title) " ,  nativeQuery = true)
    List<IBookToAvailability> findByTitleOrAuthor(@Param("title") String title, @Param("author") String author);

    @Query("SELECT b from BookEntity b LEFT JOIN BookBorrowerEntity bb ON b.id = bb.bookId WHERE bb.bookId IS NULL ORDER BY b.id")
    List<BookEntity> findBooksAvailableForRenting();

    @Query(value="SELECT b.id, b.title, b.author, b.page_nr from books b " +
            "LEFT JOIN book_borrower bb ON b.id = bb.book_id " +
            "RIGHT JOIN book_owner bo ON bo.book_id = b.id AND bo.user_id <> :id " +
            "WHERE bb.book_id IS NULL AND b.id IS NOT NULL ORDER BY b.id", nativeQuery = true)
    List<BookEntity> findBooksAvailableForRenting(@Param("id") Integer userId);

    @Query(value="SELECT " +
            "u.username AS userUsername, " +
            "b.title AS bookTitle, " +
            "bb.expected_return_timestamp AS expectedReturnTimestamp " +
            "FROM books b " +
            "RIGHT JOIN book_owner bo ON b.id = bo.book_id AND bo.user_id = :id " +
            "RIGHT JOIN book_borrower bb ON b.id = bb.book_id AND bb.user_id <> :id " +
            "RIGHT JOIN users u ON bb.user_id = u.id " +
            "WHERE b.id IS NOT NULL AND u.id IS NOT NULL", nativeQuery = true)
    List<IBorrowerToBookToExpectedReturnTimestamp> getBooksOfUserBorrowedByOthers(@Param("id") int userId);

    @Query(value="SELECT b.title AS bookTitle, " +
            "b.author AS bookAuthor, " +
            "bb.expected_return_timestamp AS expectedReturnTimestamp " +
            "FROM books b " +
            "RIGHT JOIN book_borrower bb ON b.id = bb.book_id AND bb.user_id = :id " +
            "WHERE b.id IS NOT NULL", nativeQuery = true )
    List<IBooksRentedByASpecificUser> getNotOwnedBooksRentedByMyself(@Param("id") int userId);
}

