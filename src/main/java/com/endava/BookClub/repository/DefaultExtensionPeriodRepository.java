package com.endava.BookClub.repository;

import com.endava.BookClub.entity.DefaultExtensionPeriodEntity;
import com.endava.BookClub.entity.DefaultExtensionPeriodId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultExtensionPeriodRepository extends JpaRepository<DefaultExtensionPeriodEntity, DefaultExtensionPeriodId>  {
}
