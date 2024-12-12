package com.example.order_layer.service;

import com.example.order_layer.entity.Order;
import com.example.order_layer.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired

    private OrderRepository orderRepository;

    //buy the products
    public Order buy(String name){
        return orderRepository.findByName(name);

    }

    public Order payments(Integer quantity){
        return orderRepository.findByQuantity(quantity);
    }

    public List<Order> invoice(){
        return orderRepository.findAll();

    }


}
