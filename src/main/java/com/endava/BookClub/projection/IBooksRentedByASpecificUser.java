package com.endava.BookClub.projection;

import java.time.LocalDateTime;

public interface IBooksRentedByASpecificUser {
    String getBookTitle();
    String getBookAuthor();
    LocalDateTime getExpectedReturnTimestamp();
}
