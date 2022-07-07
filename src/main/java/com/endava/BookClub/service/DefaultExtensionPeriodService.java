package com.endava.BookClub.service;

import com.endava.BookClub.entity.DefaultExtensionPeriodEntity;
import com.endava.BookClub.repository.DefaultExtensionPeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultExtensionPeriodService {
    @Autowired
    private DefaultExtensionPeriodRepository defaultExtensionPeriodRepository;

    public void save(DefaultExtensionPeriodEntity defaultExtensionPeriodEntity) {
        defaultExtensionPeriodRepository.save(defaultExtensionPeriodEntity);
    }
}
