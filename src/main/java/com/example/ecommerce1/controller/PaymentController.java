package com.example.ecommerce1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce1.entity.Payment;

import com.example.ecommerce1.service.PaymentService;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/customer/payment")
public class PaymentController {
    @Autowired
    PaymentService ps;

    @GetMapping("getpaymentall")
    public List<Payment> getPaymentAll() {
        return ps.getPaymentAll();
    }

    @GetMapping("/getpayment/{id}")
    public Map<String, Object> getPaymentData(@PathVariable String id) {
        return ps.getPaymentData(id);
    }

    @PostMapping("/addpayment")
    public Payment addPayment(@RequestBody Payment payment) {

        return ps.addPayment(payment);
    }

}