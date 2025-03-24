package com.example.ecommerce1.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce1.entity.Payment;

import com.example.ecommerce1.repository.PaymentReposit;

import com.example.ecommerce1.serviceinterface.PaymentImpl;

@Service
public class PaymentService implements PaymentImpl {

    @Autowired
    PaymentReposit pr;

    @Override
    public Map<String, Object> getPaymentData(String id) {
        List<Object[]> vr = pr.getPaymentData(id);
        // Map<String, Object> mp = new LinkedHashMap<>();
        if (vr.isEmpty()) {
            throw new RuntimeException("No Data Available");
        } else {
            Object[] ob = vr.get(0);
            Map<String, Object> mp = new LinkedHashMap<>();
            mp.put("productName", ob[0]);
            mp.put("transaction_id", ob[1]);
            mp.put("amount", ob[2]);
            mp.put("date", ob[3]);
            mp.put("time", ob[4]);
            mp.put("payment_mode", ob[5]);
            mp.put("status", ob[6]);
            return mp;
        }

    }

    @Override
    public Payment addPayment(Payment payment) {
        return pr.save(payment);
    }

    @Override
    public List<Payment> getPaymentAll() {
        return pr.findAll();
    }

}