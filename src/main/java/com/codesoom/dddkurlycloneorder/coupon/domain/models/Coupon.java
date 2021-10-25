package com.codesoom.dddkurlycloneorder.coupon.domain.models;

import javax.persistence.*;

@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    private String couponId;

    @Column(name = "coupon_name")
    private String couponName;

    @OneToOne(targetEntity = Discount.class)
    private Discount discount;
}
