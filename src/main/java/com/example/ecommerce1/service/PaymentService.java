package com.example.ecommerce1.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce1.repository.ProductReposit;
import com.example.ecommerce1.repository.VendorReposit;
import com.example.ecommerce1.serviceinterface.PaymentImpl;
@Service
public class PaymentService implements PaymentImpl {
    
    @Autowired
    ProductReposit pr;
    @Autowired
    VendorReposit vr;
    @Override
    public Map<String, Object> getPaymentData(String id) {
        List<Object[]> vr = pr.getPaymentData(id);
        if (vr.isEmpty()) {
            throw new RuntimeException("No Data Available");
        } else {
            Object[] ob = vr.get(0);
            Map<String, Object> mp = new LinkedHashMap<>();
            mp.put("product Name", ob[0]);
            mp.put("Transaction_Id", ob[1]);
            mp.put("Amount", ob[2]);
            mp.put("Date", ob[3]);
            mp.put("Time", ob[4]);
            mp.put("Payment_mode", ob[5]);
            mp.put("status", ob[6]);

        }
        return null;
    }
}
