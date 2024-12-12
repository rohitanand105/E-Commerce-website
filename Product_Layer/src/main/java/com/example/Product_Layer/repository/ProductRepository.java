package com.example.Product_Layer.repository;

import com.example.Product_Layer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
