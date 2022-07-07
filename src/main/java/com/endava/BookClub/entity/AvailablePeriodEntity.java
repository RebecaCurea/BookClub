package com.endava.BookClub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="available_periods")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AvailablePeriodId.class)
public class AvailablePeriodEntity implements Serializable {
    @Id
    private Integer quantity;
    @Id
    private String unit;
}
