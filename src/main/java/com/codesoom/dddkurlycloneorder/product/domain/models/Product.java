package com.codesoom.dddkurlycloneorder.product.domain.models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private String productId;

    @Column(name = "name")
    private String name;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount_rate")
    private Double discountRate;

    @OneToOne(targetEntity = Stock.class)
    private Stock stock;
}
