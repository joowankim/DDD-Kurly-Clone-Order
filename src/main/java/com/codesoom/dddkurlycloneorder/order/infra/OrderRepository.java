package com.codesoom.dddkurlycloneorder.order.infra;

import com.codesoom.dddkurlycloneorder.order.domain.models.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}

