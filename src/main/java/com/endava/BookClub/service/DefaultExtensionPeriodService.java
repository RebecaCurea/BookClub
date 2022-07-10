package com.endava.BookClub.service;

import com.endava.BookClub.entity.DefaultExtensionPeriodEntity;
import com.endava.BookClub.entity.DefaultExtensionPeriodId;
import com.endava.BookClub.repository.DefaultExtensionPeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DefaultExtensionPeriodService {
    @Autowired
    private DefaultExtensionPeriodRepository defaultExtensionPeriodRepository;

    public void save(DefaultExtensionPeriodEntity defaultExtensionPeriodEntity) {
        defaultExtensionPeriodRepository.save(defaultExtensionPeriodEntity);
    }

    public LocalDateTime getExpectedReturnTimestamp(
            LocalDateTime currentExpectedReturnTimestamp,
            DefaultExtensionPeriodId defaultExtensionPeriodId) {
        return currentExpectedReturnTimestamp.plusWeeks(
                defaultExtensionPeriodRepository
                    .findById(defaultExtensionPeriodId)
                    .get()
                    .getQuantity()
        );
    }
}
