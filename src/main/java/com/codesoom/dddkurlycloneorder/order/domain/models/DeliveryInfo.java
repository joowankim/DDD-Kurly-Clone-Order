package com.codesoom.dddkurlycloneorder.order.domain.models;

import javax.persistence.*;

@Entity
public class DeliveryInfo {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = Address.class)
    private Address destinationAddress;

    @OneToOne(targetEntity = DeliveryDetails.class)
    private DeliveryDetails deliveryDetails;
}
