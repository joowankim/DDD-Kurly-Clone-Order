package com.codesoom.dddkurlycloneorder.order.dto;

import com.codesoom.dddkurlycloneorder.order.domain.models.vo.DeliveryInfo;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderSheetData {
    @NotNull
    private Map<String, Double> items;

    @NotNull
    private String memberId;

    @NotNull
    private DeliveryInfo deliveryInfo;

    @NotNull
    private List<String> coupons;

    @NotNull
    private Double reserves;

    @NotNull
    private String paymentMethod;

    @NotNull
    private AgreementPair agreement;
}
