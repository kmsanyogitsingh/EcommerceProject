package com.example.ecommerce1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce1.Entity.Customer;
@Repository
public interface CustomerReposit  extends JpaRepository<Customer,Integer>{
}
