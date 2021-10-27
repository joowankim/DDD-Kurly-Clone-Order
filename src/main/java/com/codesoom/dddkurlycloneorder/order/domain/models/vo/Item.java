package com.codesoom.dddkurlycloneorder.order.domain.models.vo;

import com.codesoom.dddkurlycloneorder.product.domain.models.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Item {
    @Id @GeneratedValue
    private Long id;

    @OneToOne(targetEntity = Product.class)
    private Product product;

    @Column(name = "quantity")
    private Double quantity;

    public Item(Product product, Double quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
