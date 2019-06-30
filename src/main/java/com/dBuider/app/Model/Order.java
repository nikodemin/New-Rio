package com.dBuider.app.Model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class Order
{
    private final String address;
    @OneToOne
    private final User user;
    private final String[] filenames;
    private final Date date;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
}