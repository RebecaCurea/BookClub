package com.endava.BookClub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class DefaultExtensionPeriodId implements Serializable {
    private Integer quantity;
    private String unit;
}
