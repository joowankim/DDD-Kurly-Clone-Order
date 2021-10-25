package com.codesoom.dddkurlycloneorder.product.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "unit")
    private String unit;

    @Column(name = "amount")
    private Double amount;
}
