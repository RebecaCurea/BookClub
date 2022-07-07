package com.endava.BookClub.repository;
import com.endava.BookClub.entity.BookOwnerEntity;
import com.endava.BookClub.entity.BookOwnerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOwnerRepository extends JpaRepository<BookOwnerEntity, BookOwnerId> {
}