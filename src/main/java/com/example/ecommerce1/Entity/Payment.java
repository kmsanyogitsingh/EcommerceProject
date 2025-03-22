package com.example.ecommerce1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table

public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false, length = 8)
    private String id;
    @Column(nullable = false)
    private String productName;
    @Column(unique = true, nullable = false)
    private String product_id;
    @Column(unique = true, nullable = false, length = 8)
    private String transactionId;
    @Column(unique = true, nullable = false)
    private String vendor_id;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String payment_mode;
    @Column(nullable = false)
    private String status;
    
    @PrePersist
    public  void getId(String id){
        this.id="Pay"+id;
    }

}
