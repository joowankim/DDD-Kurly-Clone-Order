package com.codesoom.dddkurlycloneorder.order.domain.models;

import com.codesoom.dddkurlycloneorder.coupon.domain.models.Coupon;
import com.codesoom.dddkurlycloneorder.member.domain.models.Member;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderSheet {
    @Id @GeneratedValue
    private Long id;

    @OneToMany(targetEntity = Item.class)
    private List<Item> items;

    @ManyToOne(targetEntity = Member.class)
    private Member orderer;

    @OneToOne(targetEntity = DeliveryInfo.class)
    private DeliveryInfo deliveryInfo;

    @ManyToOne(targetEntity = PaymentMethod.class)
    private PaymentMethod paymentMethod;

    @OneToMany(targetEntity = Coupon.class)
    private List<Coupon> usedCoupons;

    @OneToOne(targetEntity = Agreement.class)
    private Agreement agreement;

    @OneToOne(targetEntity = Bill.class)
    private Bill bill;
}
