package com.MicroService.MicroServicePractice.repository;

import com.MicroService.MicroServicePractice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
