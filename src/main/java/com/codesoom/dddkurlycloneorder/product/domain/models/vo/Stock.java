package com.codesoom.dddkurlycloneorder.product.domain.models.vo;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
public class Stock {
    @Column(name = "unit")
    private String unit;

    @Column(name = "amount")
    private Double amount;

    public Stock(String unit, Double amount) {
        this.unit = unit;
        this.amount = amount;
    }
}
