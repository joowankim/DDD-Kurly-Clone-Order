package com.codesoom.dddkurlycloneorder.coupon.domain.models.entity;

import com.codesoom.dddkurlycloneorder.coupon.domain.models.vo.Discount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "coupons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Coupon {
    @Id
    private String couponId;

    @Column(name = "coupon_name")
    private String couponName;

    @Embedded
    private Discount discount;
}
