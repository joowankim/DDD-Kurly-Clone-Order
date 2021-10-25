package com.codesoom.dddkurlycloneorder.coupon.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Discount {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "unit")
    private String unit;

    @Column(name = "amount")
    private Double amount;
}
