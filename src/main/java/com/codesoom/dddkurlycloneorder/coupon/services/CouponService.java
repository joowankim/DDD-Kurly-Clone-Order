package com.codesoom.dddkurlycloneorder.coupon.services;

import com.codesoom.dddkurlycloneorder.coupon.domain.models.entity.Coupon;
import com.codesoom.dddkurlycloneorder.coupon.infra.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    public List<Coupon> getCoupons(List<String> coupons) {
        return couponRepository.findAllById(coupons);
    }
}
