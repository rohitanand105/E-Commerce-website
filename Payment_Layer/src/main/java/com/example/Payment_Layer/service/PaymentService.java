package com.example.Payment_Layer.service;

import com.example.Payment_Layer.entity.PaymentEntity;
import com.example.Payment_Layer.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentEntity processPayment(PaymentEntity payment) {
        payment.setTransactionId(UUID.randomUUID().toString());  // Generating random transaction ID
        payment.setPaymentStatus("SUCCESS");  // Hardcoded for simplicity
        return paymentRepository.save(payment);
    }

    public PaymentEntity getPaymentDetails(String orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
