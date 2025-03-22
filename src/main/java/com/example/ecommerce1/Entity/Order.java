package com.example.ecommerce1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( unique =  true,nullable = false,length = 7)
    private int id; 
    @Column( name = "Order_Name",nullable = false,length = 90)
    private String customerName;
    @Column( nullable = false)
    private String productName;
    @Column( nullable = false)
    private String quantity;
    @Column( nullable = false)
    private double price;

}
