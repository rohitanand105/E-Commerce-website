package com.example.Payment_Layer.repository;

import com.example.Payment_Layer.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    PaymentEntity findByOrderId(String orderId);

}
