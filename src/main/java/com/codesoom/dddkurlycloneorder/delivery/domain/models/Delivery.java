package com.codesoom.dddkurlycloneorder.delivery.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    private String deliveryId;

    @Column(name = "state")
    private String State;
}
