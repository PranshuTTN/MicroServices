package com.MicroService.MicroService1.repository;


import com.MicroService.MicroService1.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
    Coupon findByCode(String code);
}