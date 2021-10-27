package com.codesoom.dddkurlycloneorder.order.dto;

import com.codesoom.dddkurlycloneorder.coupon.domain.models.entity.Coupon;
import com.codesoom.dddkurlycloneorder.member.domain.models.entity.Member;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.Agreement;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.DeliveryInfo;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.Item;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderSheetRequired {
    private List<Item> items;
    private Member orderer;
    private DeliveryInfo deliveryInfo;
    private PaymentMethod paymentMethod;
    private List<Coupon> usedCoupons;
    private Agreement agreement;
    private Double reserves;
}
