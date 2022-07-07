package com.endava.BookClub.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class WaitingListId implements Serializable {
    private Integer userId;
    private Integer bookId;
}
