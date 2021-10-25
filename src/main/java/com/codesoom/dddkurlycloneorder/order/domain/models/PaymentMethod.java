package com.codesoom.dddkurlycloneorder.order.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PaymentMethod {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
}
