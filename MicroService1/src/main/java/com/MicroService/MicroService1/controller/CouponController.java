package com.MicroService.MicroService1.controller;

import com.MicroService.MicroService1.entities.Coupon;
import com.MicroService.MicroService1.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CouponController {
    @Autowired
    CouponRepository couponRepository;

    @PostMapping("/coupons")
    public Coupon createCoupon(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }
    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code")String code){
        return couponRepository.findByCode(code);
    }
}
