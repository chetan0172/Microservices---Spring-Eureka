package com.techie.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techie.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}