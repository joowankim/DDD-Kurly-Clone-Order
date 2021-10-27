package com.codesoom.dddkurlycloneorder.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemPair {
    private String productId;
    private Double quantity;
}
