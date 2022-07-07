package com.endava.BookClub.service;

import com.endava.BookClub.entity.AvailablePeriodId;
import com.endava.BookClub.entity.BookBorrowerEntity;
import com.endava.BookClub.model.UserToBookToAvailablePeriod;
import com.endava.BookClub.repository.BookBorrowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookBorrowerService {
    @Autowired
    private BookBorrowerRepository bookBorrowerRepository;
    @Autowired
    private AvailablePeriodService availablePeriodService;

    @Transactional
    public void rentBookForPeriod(UserToBookToAvailablePeriod userToBookToAvailablePeriod) {
        Integer bookId = userToBookToAvailablePeriod.getBookId();
        Integer userId = userToBookToAvailablePeriod.getUserId();
        AvailablePeriodId availablePeriodId = userToBookToAvailablePeriod.getAvailablePeriodId();

        LocalDateTime expectedReturnTimestamp = availablePeriodService
                .getExpectedReturnTimestamp(availablePeriodId);

        BookBorrowerEntity bookBorrowerEntity = BookBorrowerEntity
                .builder()
                .bookId(bookId)
                .userId(userId)
                .expectedReturnTimestamp(expectedReturnTimestamp)
                .build();

        bookBorrowerRepository.save(bookBorrowerEntity);
    }
}
