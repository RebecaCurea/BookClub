package com.endava.BookClub.repository;

import com.endava.BookClub.entity.AvailablePeriodEntity;
import com.endava.BookClub.entity.AvailablePeriodId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailablePeriodRepository extends JpaRepository<AvailablePeriodEntity, AvailablePeriodId>  {
}
