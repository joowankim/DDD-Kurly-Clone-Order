package com.codesoom.dddkurlycloneorder.order.domain.models.entity;

import com.codesoom.dddkurlycloneorder.delivery.domain.models.vo.DeliveryState;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.OrderSheet;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.OrderState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Order {
    @Id
    private String orderId;

    @Embedded
    private OrderSheet orderSheet;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "order_state"))
    private OrderState orderState;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "delivery_state"))
    private DeliveryState deliveryState;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
