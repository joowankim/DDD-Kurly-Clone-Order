package com.codesoom.dddkurlycloneorder.order.controllers;

import com.codesoom.dddkurlycloneorder.coupon.domain.models.entity.Coupon;
import com.codesoom.dddkurlycloneorder.coupon.domain.models.vo.Discount;
import com.codesoom.dddkurlycloneorder.member.domain.models.entity.Member;
import com.codesoom.dddkurlycloneorder.member.domain.models.vo.Reserves;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.*;
import com.codesoom.dddkurlycloneorder.order.dto.AgreementPair;
import com.codesoom.dddkurlycloneorder.order.dto.ItemPair;
import com.codesoom.dddkurlycloneorder.order.dto.OrderSheetData;
import com.codesoom.dddkurlycloneorder.product.domain.models.entity.Product;
import com.codesoom.dddkurlycloneorder.product.domain.models.vo.Stock;
import com.codesoom.dddkurlycloneorder.terms.domain.models.entity.Terms;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private OrderSheetData anOrderSheetData() {
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

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void create() throws Exception {
        OrderSheetData orderSheetData = anOrderSheetData();
        String requestBody = objectMapper.writeValueAsString(orderSheetData);
        mockMvc.perform(
            post("/orders")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody)
        )
                .andExpect(status().isCreated());
    }
}
