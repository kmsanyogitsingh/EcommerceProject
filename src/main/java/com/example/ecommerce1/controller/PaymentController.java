package com.example.ecommerce1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce1.service.PaymentService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/customer/payment")
public class PaymentController {
    @Autowired
    PaymentService ps;

    @GetMapping("/getpayment")
    public Map<String, Object> getMethodName(@PathVariable String id) {
        return ps.getPaymentData(id);
    }

}
