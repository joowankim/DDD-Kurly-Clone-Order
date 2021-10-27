package com.codesoom.dddkurlycloneorder.order.domain.models.service;

import com.codesoom.dddkurlycloneorder.order.domain.models.entity.Order;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.Bill;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.OrderSheet;
import com.codesoom.dddkurlycloneorder.order.dto.OrderSheetData;
import com.codesoom.dddkurlycloneorder.order.dto.OrderSheetRequired;
import com.codesoom.dddkurlycloneorder.order.infra.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class ReceptionDesk {

    private final PointOfSale pointOfSale;
    private final OrderRepository orders;

    public ReceptionDesk(PointOfSale pointOfSale, OrderRepository orderRepository) {
        this.pointOfSale = pointOfSale;
        this.orders = orderRepository;
    }

    private OrderSheet writeWith(OrderSheetRequired anOrderSheetRequired) {
        Bill bill = pointOfSale.calculate(anOrderSheetRequired);
        return new OrderSheet(
                anOrderSheetRequired.getItems(),
                anOrderSheetRequired.getOrderer(),
                anOrderSheetRequired.getDeliveryInfo(),
                anOrderSheetRequired.getPaymentMethod(),
                anOrderSheetRequired.getUsedCoupons(),
                anOrderSheetRequired.getAgreement(),
                bill
        );
    }

    public void register(OrderSheetRequired anOrderSheetRequired) {
        OrderSheet orderSheet = writeWith(anOrderSheetRequired);
        Order order = pointOfSale.createOrderOf(orderSheet);
        orders.save(order);
        // TODO: publish OrderCreated event
    }
}
