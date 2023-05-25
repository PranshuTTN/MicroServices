package com.MicroService.MicroServicePractice.controller;

import com.MicroService.MicroServicePractice.entities.Coupon;
import com.MicroService.MicroServicePractice.entities.Product;
import com.MicroService.MicroServicePractice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RestTemplate restTemplate;
    @Value("${couponService.url}")
    private String couponServiceURL;

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        Coupon coupon = restTemplate.getForObject(couponServiceURL+product.getCouponCode(),Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepository.save(product);
    }

}
