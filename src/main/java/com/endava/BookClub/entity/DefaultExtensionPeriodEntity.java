package com.endava.BookClub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="default_extension_periods")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(DefaultExtensionPeriodId.class)
public class DefaultExtensionPeriodEntity {
    @Id
    private Integer quantity;
    @Id
    private String unit;
}