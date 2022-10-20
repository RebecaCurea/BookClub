package com.endava.BookClub.service;

import com.endava.BookClub.entity.AvailablePeriodId;
import com.endava.BookClub.entity.BookBorrowerEntity;
import com.endava.BookClub.entity.BookBorrowerId;
import com.endava.BookClub.entity.DefaultExtensionPeriodId;
import com.endava.BookClub.model.UserToBookToAvailablePeriod;
import com.endava.BookClub.model.BookBorrowerIdToDefaultPeriod;
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

    @Autowired
    private DefaultExtensionPeriodService defaultExtensionPeriodService;

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

    @Transactional
    public void extendRentingPeriodForBook(BookBorrowerIdToDefaultPeriod bookBorrowerIdToDefaultPeriod) {
        BookBorrowerId bookBorrowerId = bookBorrowerIdToDefaultPeriod.getBookBorrowerId();
        Integer userId = bookBorrowerId.getUserId();
        Integer bookId = bookBorrowerId.getBookId();
        DefaultExtensionPeriodId defaultExtensionPeriodId = bookBorrowerIdToDefaultPeriod.getDefaultExtensionPeriodId();

        LocalDateTime currentExpectedReturnTimestamp = bookBorrowerRepository
                .findByBookAndUser(bookId, userId)
                .get(0)
                .getExpectedReturnTimestamp();

        LocalDateTime nextExpectedReturnTimestamp = defaultExtensionPeriodService
                .getExpectedReturnTimestamp(currentExpectedReturnTimestamp, defaultExtensionPeriodId);

        bookBorrowerRepository.updateExpectedReturnTimestamp(
                nextExpectedReturnTimestamp,
                userId,
                bookId
        );
    }
}
