package com.codesoom.dddkurlycloneorder.order.domain.models.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DeliveryInfo {
    @Embedded
    private Address destinationAddress;

    @Embedded
    private DeliveryDetails deliveryDetails;
}
