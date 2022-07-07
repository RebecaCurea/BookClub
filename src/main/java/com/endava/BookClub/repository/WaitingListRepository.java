package com.endava.BookClub.repository;

import com.endava.BookClub.entity.WaitingListEntity;
import com.endava.BookClub.entity.WaitingListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitingListRepository extends JpaRepository<WaitingListEntity, WaitingListId> {
}
