package com.codesoom.dddkurlycloneorder.order.domain.models.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
@Getter
public class Bill {
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

    public Bill(
            Double originalPrice, Double productDiscount, Double couponDiscount,
            Double deliveryFee, Double usedReserves, Double totalPrice
    ) {
        this.originalPrice = originalPrice;
        this.productDiscount = productDiscount;
        this.couponDiscount = couponDiscount;
        this.deliveryFee = deliveryFee;
        this.usedReserves = usedReserves;
        this.totalPrice = totalPrice;
    }
}
