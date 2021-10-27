package com.codesoom.dddkurlycloneorder.product.domain.models.entity;

import com.codesoom.dddkurlycloneorder.product.domain.models.vo.Stock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
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

    @Embedded
    private Stock stock;
}
