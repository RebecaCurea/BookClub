package com.endava.BookClub.service;

import com.endava.BookClub.entity.AvailablePeriodEntity;
import com.endava.BookClub.entity.AvailablePeriodId;
import com.endava.BookClub.repository.AvailablePeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AvailablePeriodService {
    @Autowired
    private AvailablePeriodRepository availablePeriodRepository;

    public void save(AvailablePeriodEntity availablePeriodEntity) {
        availablePeriodRepository.save(availablePeriodEntity);
    }

    public LocalDateTime getExpectedReturnTimestamp(AvailablePeriodId availablePeriodId) {

            AvailablePeriodEntity availablePeriodEntity = availablePeriodRepository.findById(availablePeriodId).get();

            Integer quantity = availablePeriodEntity.getQuantity();
            String unit = availablePeriodEntity.getUnit();

            return unit.equals("week") ?
                    LocalDateTime.now().plusWeeks(quantity) :
                    LocalDateTime.now().plusMonths(quantity);

    }
}
