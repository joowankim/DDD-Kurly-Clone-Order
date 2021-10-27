package com.codesoom.dddkurlycloneorder.order.services;

import com.codesoom.dddkurlycloneorder.coupon.domain.models.entity.Coupon;
import com.codesoom.dddkurlycloneorder.coupon.services.CouponService;
import com.codesoom.dddkurlycloneorder.member.domain.models.entity.Member;
import com.codesoom.dddkurlycloneorder.member.services.MemberService;
import com.codesoom.dddkurlycloneorder.order.domain.models.service.ReceptionDesk;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.Agreement;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.DeliveryInfo;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.Item;
import com.codesoom.dddkurlycloneorder.order.domain.models.vo.PaymentMethod;
import com.codesoom.dddkurlycloneorder.order.dto.ItemPair;
import com.codesoom.dddkurlycloneorder.order.dto.OrderSheetData;
import com.codesoom.dddkurlycloneorder.order.dto.OrderSheetRequired;
import com.codesoom.dddkurlycloneorder.product.domain.models.entity.Product;
import com.codesoom.dddkurlycloneorder.product.services.ProductService;
import com.codesoom.dddkurlycloneorder.terms.services.TermsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ReceptionDesk receptionDesk;
    private final ProductService productService;
    private final TermsService termsService;
    private final CouponService couponService;
    private final MemberService memberService;

    private OrderSheetRequired getRequiredFrom(OrderSheetData anOrderSheetData) {
        List<Item> items = productService.getProducts(new ArrayList<>(anOrderSheetData.getItems().keySet()))
                .stream().map(product -> new Item(product, anOrderSheetData.getItems().get(product.getProductId())))
                .collect(Collectors.toList());
        Member orderer = memberService.get(anOrderSheetData.getMemberId());
        DeliveryInfo deliveryInfo = anOrderSheetData.getDeliveryInfo();
        PaymentMethod paymentMethod = new PaymentMethod(anOrderSheetData.getPaymentMethod());
        List<Coupon> usedCoupons = couponService.getCoupons(anOrderSheetData.getCoupons());
        Double reserves = anOrderSheetData.getReserves();
        Agreement agreement = new Agreement(
                termsService.get(anOrderSheetData.getAgreement().getTermsId()),
                anOrderSheetData.getAgreement().getShouldCheckAgreement()
        );
        return new OrderSheetRequired(
                items, orderer, deliveryInfo, paymentMethod, usedCoupons, agreement, reserves
        );
    }

    public void orderWith(OrderSheetData orderSheetData) {
        OrderSheetRequired required = getRequiredFrom(orderSheetData);
        receptionDesk.register(required);
    }
}
