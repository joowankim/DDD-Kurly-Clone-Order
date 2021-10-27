package com.codesoom.dddkurlycloneorder.order.domain.models.vo;

import com.codesoom.dddkurlycloneorder.coupon.domain.models.entity.Coupon;
import com.codesoom.dddkurlycloneorder.member.domain.models.entity.Member;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Embeddable
@NoArgsConstructor
public class OrderSheet {
    @OneToMany(targetEntity = Item.class)
    private List<Item> items;

    @ManyToOne(targetEntity = Member.class)
    private Member orderer;

    @Embedded
    private DeliveryInfo deliveryInfo;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "payment_method"))
    private PaymentMethod paymentMethod;

    @OneToMany(targetEntity = Coupon.class)
    private List<Coupon> usedCoupons;

    @Embedded
    private Agreement agreement;

    @Embedded
    private Bill bill;

    public OrderSheet(
            List<Item> items, Member orderer, DeliveryInfo deliveryInfo, PaymentMethod paymentMethod,
            List<Coupon> coupons, Agreement agreement, Bill bill) {
        this.items = items;
        this.orderer = orderer;
        this.deliveryInfo = deliveryInfo;
        this.paymentMethod = paymentMethod;
        this.usedCoupons = coupons;
        this.agreement = agreement;
        this.bill = bill;
    }
}
