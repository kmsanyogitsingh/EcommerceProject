package com.example.ecommerce1.serviceinterface;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ecommerce1.entity.Payment;

@Service
public interface PaymentImpl {
    public Map<String, Object> getPaymentData(@PathVariable String id);

    public Payment addPayment(@RequestBody Payment payment);

    public List<Payment> getPaymentAll();
}