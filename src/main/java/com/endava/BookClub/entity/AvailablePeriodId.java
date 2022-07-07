package com.endava.BookClub.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class AvailablePeriodId implements Serializable {
    private Integer quantity;
    private String unit;
}