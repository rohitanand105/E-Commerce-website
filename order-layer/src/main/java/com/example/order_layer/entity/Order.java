package com.example.order_layer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;

        private String username;
        private String password;
        private String name;
        private Integer quantity;





}
