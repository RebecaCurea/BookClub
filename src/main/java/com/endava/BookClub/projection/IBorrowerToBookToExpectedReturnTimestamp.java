package com.endava.BookClub.projection;

import java.time.LocalDateTime;

public interface IBorrowerToBookToExpectedReturnTimestamp {
    String getUserUsername();
    String getBookTitle();
    LocalDateTime getExpectedReturnTimestamp();
}
