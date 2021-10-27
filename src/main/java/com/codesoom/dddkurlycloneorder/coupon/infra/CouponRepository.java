package com.codesoom.dddkurlycloneorder.coupon.infra;

import com.codesoom.dddkurlycloneorder.coupon.domain.models.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, String> {
}
