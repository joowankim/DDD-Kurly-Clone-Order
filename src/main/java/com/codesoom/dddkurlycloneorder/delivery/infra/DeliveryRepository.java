package com.codesoom.dddkurlycloneorder.delivery.infra;

import com.codesoom.dddkurlycloneorder.delivery.domain.models.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, String> {
}
