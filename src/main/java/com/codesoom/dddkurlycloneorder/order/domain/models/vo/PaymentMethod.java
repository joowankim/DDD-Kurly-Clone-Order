package com.codesoom.dddkurlycloneorder.order.domain.models.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {
    private String value;
}
