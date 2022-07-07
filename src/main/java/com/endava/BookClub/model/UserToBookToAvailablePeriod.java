package com.endava.BookClub.model;

import com.endava.BookClub.entity.AvailablePeriodId;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserToBookToAvailablePeriod {
    private Integer userId;
    private Integer bookId;
    private AvailablePeriodId availablePeriodId;
}
