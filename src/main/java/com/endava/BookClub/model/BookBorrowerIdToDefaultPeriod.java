package com.endava.BookClub.model;

import com.endava.BookClub.entity.BookBorrowerId;
import com.endava.BookClub.entity.DefaultExtensionPeriodId;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class BookBorrowerIdToDefaultPeriod {
    private BookBorrowerId bookBorrowerId;
    private DefaultExtensionPeriodId defaultExtensionPeriodId;
}
