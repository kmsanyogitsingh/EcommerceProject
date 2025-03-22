package com.example.ecommerce1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecommerce1.entity.Payment;

@Repository
public interface PaymentReposit extends JpaRepository<Payment, String> {

    @Query(value = "SELECT product_name, transaction_id, amount, date, time, payment_mode, status FROM payment WHERE id = :id", nativeQuery = true)
    public List<Object[]> getPaymentData(@Param("id") String id);
}



