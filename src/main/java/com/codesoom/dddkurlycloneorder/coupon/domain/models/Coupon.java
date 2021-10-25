package com.codesoom.dddkurlycloneorder.coupon.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Coupon {
    @Id
    private String couponId;

    @Column(name = "coupon_name")
    private String couponName;

    @OneToOne(targetEntity = Discount.class)
    private Discount discount;
}
