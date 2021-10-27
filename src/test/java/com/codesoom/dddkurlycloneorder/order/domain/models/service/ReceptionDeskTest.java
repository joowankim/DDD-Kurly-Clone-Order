package com.codesoom.dddkurlycloneorder.order.domain.models.service;

import com.codesoom.dddkurlycloneorder.coupon.domain.models.entity.Coupon;
import com.codesoom.dddkurlycloneorder.coupon.domain.models.vo.Discount;
import com.codesoom.dddkurlycloneorder.member.domain.models.entity.Member;
import com.codesoom.dddkurlycloneorder.member.domain.models.vo.Reserves;
import com.codesoom.dddkurlycloneorder.order.domain.models.entity.Order;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.*;
import com.codesoom.dddkurlycloneorder.order.dto.OrderSheetData;
import com.codesoom.dddkurlycloneorder.order.dto.OrderSheetRequired;
import com.codesoom.dddkurlycloneorder.order.infra.OrderRepository;
import com.codesoom.dddkurlycloneorder.product.domain.models.entity.Product;
import com.codesoom.dddkurlycloneorder.product.domain.models.vo.Stock;
import com.codesoom.dddkurlycloneorder.terms.domain.models.entity.Terms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ReceptionDeskTest {

    private ReceptionDesk receptionDesk;

    private final OrderRepository orderRepository = mock(OrderRepository.class);

    private OrderSheet anOrderSheet() {
        Product product1 = new Product(
                "product-1", "mouse", "https://thumbs1",
                4000.0, 0.0, new Stock("ea", 12.0)
        );
        Product product2 = new Product(
                "product-2", "monitor", "https://thumbs2",
                100000.0, 0.0, new Stock("ea", 13.0)
        );
        Item item1 = new Item(product1, 3.0);
        Item item2 = new Item(product2, 2.0);
        List<Item> orderedItems = new ArrayList<>();
        orderedItems.add(item1);
        orderedItems.add(item2);
        Member orderer = new Member(
                "member-1", "John", "01012341212",
                "email@email.com", new Reserves("KRW", 12000.0)
        );
        DeliveryInfo deliveryInfo = new DeliveryInfo(
                new Address("12323", "광장로", "14동 101호"),
                new DeliveryDetails(
                        new ReceiverInfo("John", "01012341212"),
                        "문 앞", "*23#", "배송완료 후 즉시"
                )
        );
        PaymentMethod paymentMethod = new PaymentMethod("Naver Pay");
        Coupon coupon1 = new Coupon(
                "coupon-1", "귀칼 2쿨 방영 기념 쿠폰",new Discount("percent", 30.0)
        );
        List<Coupon> usedCoupons = new ArrayList<>();
        usedCoupons.add(coupon1);
        Agreement agreement = new Agreement(
                new Terms("terms-1", "환생의 불꽃으로 사기치지 않습니다."),
                true
        );
        Bill bill = new Bill(
                212000.0, 0.0, 63600.0,
                3000.0, 10000.0, 141400.0
        );
        return new OrderSheet(
                orderedItems, orderer, deliveryInfo,
                paymentMethod, usedCoupons, agreement, bill
        );
    }

    private OrderSheetRequired anOrderSheetRequired() {
        List<Item> items = List.of(
                new Item(
                        new Product(
                                "product-1", "mouse", "https://thumbs1",
                                4000.0, 0.0, new Stock("ea", 12.0)
                        ),
                        3.0
                ),
                new Item(
                        new Product(
                                "product-2", "monitor", "https://thumbs2",
                                100000.0, 0.0, new Stock("ea", 13.0)
                        ),
                        2.0
                )
        );
        Member orderer = new Member(
                "member-1", "John", "01012341212",
                "email@email.com", new Reserves("KRW", 12000.0)
        );
        DeliveryInfo deliveryInfo = new DeliveryInfo(
                new Address("12323", "광장로", "14동 101호"),
                new DeliveryDetails(
                        new ReceiverInfo("John", "01012341212"),
                        "문 앞", "*23#", "배송완료 후 즉시"
                )
        );
        List<Coupon> coupons = List.of(
                new Coupon("coupon-1", "귀칼 2쿨 방영 기념 쿠폰",new Discount("percent", 30.0)),
                new Coupon("coupon-2", "환생의 불꽃 미안해",new Discount("KRW", 3000.0))
        );
        Double reserves = 10000.0;
        PaymentMethod paymentMethod = new PaymentMethod("Naver Pay");
        Agreement agreement = new Agreement(
                new Terms("terms-1", "asdfafasdfaf"),
                true
        );
        return new OrderSheetRequired(
                items, orderer, deliveryInfo, paymentMethod, coupons, agreement, reserves
        );
    }

    private Order anOrder() {
        PointOfSale pointOfSale = new PointOfSale();
        return pointOfSale.createOrderOf(anOrderSheet());
    }

    @BeforeEach
    void setUp() {
        PointOfSale pointOfSale = new PointOfSale();
        receptionDesk = new ReceptionDesk(pointOfSale, orderRepository);
    }

    @Test
    void register() {
        OrderSheetRequired orderSheetRequired = anOrderSheetRequired();
        Order order = anOrder();
        given(orderRepository.save(order)).willReturn(order);

        receptionDesk.register(orderSheetRequired);
        // TODO: check if OrderCreated Event is published
    }
}
