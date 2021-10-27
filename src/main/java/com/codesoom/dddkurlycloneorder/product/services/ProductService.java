package com.codesoom.dddkurlycloneorder.product.services;

import com.codesoom.dddkurlycloneorder.product.domain.models.entity.Product;
import com.codesoom.dddkurlycloneorder.product.infra.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts(List<String> itemIds) {
        return productRepository.findAllById(itemIds);
    }
}
