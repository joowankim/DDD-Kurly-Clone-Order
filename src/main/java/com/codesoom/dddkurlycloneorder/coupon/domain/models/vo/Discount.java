package com.codesoom.dddkurlycloneorder.coupon.domain.models.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Embeddable
@Getter
public class Discount {
    @Column(name = "unit")
    private String unit;

    @Column(name = "amount")
    private Double amount;

    public Discount(String unit, Double amount) {
        this.unit = unit;
        this.amount = amount;
    }
}
