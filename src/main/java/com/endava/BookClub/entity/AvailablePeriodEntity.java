package com.endava.BookClub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="available_periods")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AvailablePeriodId.class)
public class AvailablePeriodEntity  {
    @Id
    private Integer quantity;
    @Id
    private String unit;
}
