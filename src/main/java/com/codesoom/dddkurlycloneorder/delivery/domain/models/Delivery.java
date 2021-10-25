package com.codesoom.dddkurlycloneorder.delivery.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Delivery {
    @Id
    private String deliveryId;

    @Column(name = "state")
    private String State;
}
