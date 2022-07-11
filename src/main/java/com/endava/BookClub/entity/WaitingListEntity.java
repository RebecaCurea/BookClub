package com.endava.BookClub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name="waiting_list")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(WaitingListId.class)
public class WaitingListEntity {
    @Id
    private Integer bookId;
    @Id
    private Integer userId;
}
