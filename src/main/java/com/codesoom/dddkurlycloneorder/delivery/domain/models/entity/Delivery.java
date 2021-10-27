package com.codesoom.dddkurlycloneorder.delivery.domain.models.entity;

import com.codesoom.dddkurlycloneorder.delivery.domain.models.vo.DeliveryState;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "deliveries")
@NoArgsConstructor
public class Delivery {
    @Id
    private String deliveryId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "state"))
    private DeliveryState state;

    public Delivery(String deliveryId, DeliveryState state) {
        this.deliveryId = deliveryId;
        this.state = state;
    }
}
