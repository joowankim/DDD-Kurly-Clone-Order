package com.codesoom.dddkurlycloneorder.order.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bill {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "original_price")
    private Double originalPrice;

    @Column(name = "product_discount")
    private Double productDiscount;

    @Column(name = "coupon_discount")
    private Double couponDiscount;

    @Column(name = "delivery_fee")
    private Double deliveryFee;

    @Column(name = "used_reserves")
    private Double usedReserves;

    @Column(name = "total_price")
    private Double totalPrice;
}
