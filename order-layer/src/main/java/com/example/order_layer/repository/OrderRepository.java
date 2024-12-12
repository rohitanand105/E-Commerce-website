package com.example.order_layer.repository;

import com.example.order_layer.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public Order findByName(String name);
    public Order findByQuantity(Integer quantity);
}
