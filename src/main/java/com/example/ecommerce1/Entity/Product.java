package com.example.ecommerce1.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ProductDetails")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "product_name", nullable = false, length = 70)
    private String name;

    @Column(length = 255)
    private String Description;
    @Column(nullable = false, length = 50)
    private String Category;
    @Column(nullable = false, precision = 10, scale = 2)
    private String Price;

    @Column(nullable = false)
    private int rating;
    private String paymentData;
}
