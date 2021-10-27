package com.codesoom.dddkurlycloneorder.order.domain.models.service;

import com.codesoom.dddkurlycloneorder.delivery.domain.models.vo.DeliveryState;
import com.codesoom.dddkurlycloneorder.order.domain.models.entity.Order;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.Bill;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.OrderSheet;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.OrderState;
import com.codesoom.dddkurlycloneorder.order.dto.OrderSheetRequired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PointOfSale {

    private String generateOrderId() {
        UUID orderId = UUID.randomUUID();
        return "order-" + orderId;
    }

    public Bill calculate(OrderSheetRequired required) {
        Double originalPrice = required.getItems()
                .stream().map(item -> item.getProduct().getPrice() * item.getQuantity())
                .reduce(0D, Double::sum);
        Double productDiscount = required.getItems()
                .stream().map(item -> item.getProduct().getPrice() * item.getProduct().getDiscountRate())
                .reduce(0D, Double::sum);
        Double percentDiscount = required.getUsedCoupons()
                .stream().filter(coupon -> coupon.getDiscount().getUnit().equals("percent"))
                .map(coupon -> originalPrice * coupon.getDiscount().getAmount()/100.0)
                .reduce(0D, Double::sum);
        Double amountDiscount = required.getUsedCoupons()
                .stream().filter(coupon -> coupon.getDiscount().getUnit().equals("KRW"))
                .map(coupon -> coupon.getDiscount().getAmount())
                .reduce(0D, Double::sum);
        Double couponDiscount = percentDiscount + amountDiscount;
        Double deliveryFee = 0.0;
        Double usedReserves = required.getReserves();
        Double totalPrice = originalPrice - productDiscount - couponDiscount + deliveryFee - usedReserves;
        return new Bill(
                originalPrice,
                productDiscount,
                couponDiscount,
                deliveryFee,
                usedReserves,
                totalPrice
        );
    }

    public Order createOrderOf(OrderSheet orderSheet) {
        String newOrderId = generateOrderId();
        OrderState orderState = OrderState.valueOf(OrderState.getPaymentFinished());
        DeliveryState deliveryState = DeliveryState.valueOf(DeliveryState.getPaymentFinished());
        LocalDateTime now = LocalDateTime.now();
        return new Order(newOrderId, orderSheet, orderState, deliveryState, now);
    }
}
