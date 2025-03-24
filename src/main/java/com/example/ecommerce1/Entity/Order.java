package com.example.ecommerce1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OrderDetails")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(name = "customer_name", nullable = false, length = 90)
    private String customerName;

    @Column(name = "product_name", nullable = false, length = 90)
    private String productName;

    @Column(nullable = false)
    private String quantity;

    @Column(nullable = false)
    private double price;
}
