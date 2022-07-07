package com.endava.BookClub.controller;

import com.endava.BookClub.entity.AvailablePeriodEntity;
import com.endava.BookClub.entity.DefaultExtensionPeriodEntity;
import com.endava.BookClub.repository.DefaultExtensionPeriodRepository;
import com.endava.BookClub.service.AvailablePeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("config")
public class ConfigController {
    @Autowired
    private AvailablePeriodService availablePeriodService;

    @Autowired
    private DefaultExtensionPeriodRepository defaultExtensionPeriodRepository;

    @PostMapping("available-period")
    public void addAvailablePeriod(@RequestBody AvailablePeriodEntity availablePeriodEntity) {
        availablePeriodService.save(availablePeriodEntity);
    }

    @PostMapping("default-extension-period")
    public void addDefaultExtensionPeriod(@RequestBody DefaultExtensionPeriodEntity defaultExtensionPeriodEntity) {
        defaultExtensionPeriodRepository.save(defaultExtensionPeriodEntity);
    }
}
