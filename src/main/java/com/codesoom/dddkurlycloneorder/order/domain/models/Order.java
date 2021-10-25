package com.codesoom.dddkurlycloneorder.order.domain.models;

import com.codesoom.dddkurlycloneorder.delivery.domain.models.Delivery;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private String orderId;

    @OneToOne(targetEntity = OrderSheet.class)
    private OrderSheet orderSheet;

    @Column(name = "order_state")
    private String orderState;

    @OneToOne(targetEntity = Delivery.class)
    private Delivery delivery;

}
