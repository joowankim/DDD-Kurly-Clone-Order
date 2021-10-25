package com.codesoom.dddkurlycloneorder.order.domain.models;

import com.codesoom.dddkurlycloneorder.product.domain.models.Product;

import javax.persistence.*;

@Entity
public class Item {
    @Id @GeneratedValue
    private Long id;

    @OneToOne(targetEntity = Product.class)
    private Product product;

    @Column(name = "quantity")
    private Double quantity;
}
