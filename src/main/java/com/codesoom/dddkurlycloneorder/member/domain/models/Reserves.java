package com.codesoom.dddkurlycloneorder.member.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reserves {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount")
    private Double amount;
}
