package com.endava.BookClub.service;

import com.endava.BookClub.entity.WaitingListEntity;
import com.endava.BookClub.repository.WaitingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaitingListService {
    @Autowired
    private WaitingListRepository waitingListRepository;
    public void save(WaitingListEntity waitingList) {
        waitingListRepository.save(waitingList);
    }
}
