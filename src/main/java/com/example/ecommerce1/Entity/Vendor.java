
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
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false, length = 7)
    private int id;
    @Column(name = "Vender_Name" ,nullable = false, length = 50)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false, length = 10)
    private String contact;
    @Column(unique = true, nullable = false, length = 100)
    private String address;
    @Column(nullable = false, length = 10)
    private String password;

}
