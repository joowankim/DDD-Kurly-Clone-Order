package com.codesoom.dddkurlycloneorder.order.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UsedReserves {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount")
    private Double amount;
}
