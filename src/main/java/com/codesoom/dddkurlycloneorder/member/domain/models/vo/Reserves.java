package com.codesoom.dddkurlycloneorder.member.domain.models.vo;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
public class Reserves {
    @Column(name = "currency")
    private String currency;

    @Column(name = "amount")
    private Double amount;

    public Reserves(String currency, Double amount) {
        this.currency = currency;
        this.amount = amount;
    }
}
