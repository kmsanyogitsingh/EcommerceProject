package com.example.ecommerce1.serviceinterface;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface PaymentImpl {
    public Map<String, Object> getPaymentData(@PathVariable String id);

}
