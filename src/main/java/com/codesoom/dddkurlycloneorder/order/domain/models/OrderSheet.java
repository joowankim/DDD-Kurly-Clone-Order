package com.codesoom.dddkurlycloneorder.order.domain.models;

import java.util.List;

public class OrderSheet {
    private List<Item> items;
    private OrdererInfo ordererInfo;
    private DeliveryInfo deliveryInfo;
    private PaymentMethod paymentMethod;
    private List<UsedCoupon> coupons;
    private Agreement agreement;
    private Bill bill;
}
