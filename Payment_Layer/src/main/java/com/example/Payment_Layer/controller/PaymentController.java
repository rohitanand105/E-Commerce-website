package com.example.Payment_Layer.controller;

import com.example.Payment_Layer.entity.PaymentEntity;
import com.example.Payment_Layer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public PaymentEntity processPayment(@RequestBody PaymentEntity payment) {
        return paymentService.processPayment(payment);
    }

    @GetMapping("/details/{orderId}")
    public PaymentEntity getPaymentDetails(@PathVariable String orderId) {
        return paymentService.getPaymentDetails(orderId);
    }
}
