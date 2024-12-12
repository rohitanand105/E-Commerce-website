package com.example.order_layer.controller;

import com.example.order_layer.entity.Order;
import com.example.order_layer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/buy")
    public ResponseEntity<Order> buy(String name){
        Order order = orderService.buy(name);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/payments")
    public ResponseEntity<Order> payments(Integer quantity){
        Order order = orderService.payments(quantity);
        return ResponseEntity.ok(order);

    }

    @GetMapping("/invoices")
    public ResponseEntity<List<Order>> invoice(){
        List<Order> orders = orderService.invoice();
        return ResponseEntity.ok(orders);
    }



}
