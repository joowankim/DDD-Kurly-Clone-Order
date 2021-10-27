package com.codesoom.dddkurlycloneorder.order.services;

import com.codesoom.dddkurlycloneorder.coupon.services.CouponService;
import com.codesoom.dddkurlycloneorder.member.services.MemberService;
import com.codesoom.dddkurlycloneorder.order.domain.models.service.PointOfSale;
import com.codesoom.dddkurlycloneorder.order.domain.models.service.ReceptionDesk;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.Address;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.DeliveryDetails;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.DeliveryInfo;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.ReceiverInfo;
import com.codesoom.dddkurlycloneorder.order.dto.AgreementPair;
import com.codesoom.dddkurlycloneorder.order.dto.ItemPair;
import com.codesoom.dddkurlycloneorder.order.dto.OrderSheetData;
import com.codesoom.dddkurlycloneorder.order.infra.OrderRepository;
import com.codesoom.dddkurlycloneorder.product.services.ProductService;
import com.codesoom.dddkurlycloneorder.terms.services.TermsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OrderServiceTest {

    private OrderService orderService;
    private final ProductService productService = mock(ProductService.class);
    private final TermsService termsService = mock(TermsService.class);
    private final CouponService couponService = mock(CouponService.class);
    private final MemberService memberService = mock(MemberService.class);

    private OrderSheetData anOrderSheetData() {
//        List<ItemPair> items = List.of(
//                new ItemPair("product-1", 3.0),
//                new ItemPair("product-2", 2.0)
//        );
        Map<String, Double> items = Map.of(
                "product-1", 3.0,
                "product-2", 2.0
        );
        String memberId = "member-1";
        DeliveryInfo deliveryInfo = new DeliveryInfo(
                new Address("12323", "광장로", "14동 101호"),
                new DeliveryDetails(
                        new ReceiverInfo("John", "01012341212"),
                        "문 앞", "*23#", "배송완료 후 즉시"
                )
        );
        List<String> coupons = List.of(
                "coupon-1",
                "coupon-2"
        );
        Double reserves = 10000.0;
        String paymentMethod = "Naver Pay";
        AgreementPair agreement = new AgreementPair(
                "terms-1",
                true
        );
        return new OrderSheetData(
                items, memberId, deliveryInfo, coupons, reserves, paymentMethod, agreement
        );
    }

    @BeforeEach
    void setUp() {
        PointOfSale pointOfSale = new PointOfSale();
        OrderRepository orderRepository = mock(OrderRepository.class);
        ReceptionDesk receptionDesk = new ReceptionDesk(pointOfSale, orderRepository);
        orderService = new OrderService(
                receptionDesk,
                productService,
                termsService,
                couponService,
                memberService
        );
    }

    @Test
    void orderWith() {
        OrderSheetData orderSheetData = anOrderSheetData();
        orderService.orderWith(orderSheetData);
        verify(productService).getProducts(List.of("product-2", "product-1"));
        verify(memberService).get("member-1");
        verify(couponService).getCoupons(List.of("coupon-1", "coupon-2"));
        verify(termsService).get("terms-1");
    }
}
