package com.codesoom.dddkurlycloneorder.product.infra;

import com.codesoom.dddkurlycloneorder.product.domain.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
