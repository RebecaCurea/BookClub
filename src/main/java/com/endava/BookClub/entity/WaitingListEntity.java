package com.endava.BookClub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name="waiting_list")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(WaitingListId.class)
public class WaitingListEntity implements Serializable {
    @Id
    private Integer bookId;
    @Id
    private Integer userId;
}
