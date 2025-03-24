package com.example.ecommerce1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecommerce1.entity.Order;

@Repository
public interface OrderReposit extends JpaRepository<Order, Integer> {

    // @Query(value = "SELECT * FROM Order WHERE product_name = :productName",
    // nativeQuery = true)
    // public List<Order> getListByProductName(@Param("productName") String
    // productName);

    // @Query(value = "SELECT * FROM Order WHERE customer_name = :customerName",
    // nativeQuery = true)
    // public List<Order> getListByCustomerName(@Param("customerName") String
    // customerName);

    // @Query(value = "SELECT * FROM Order WHERE price = :price", nativeQuery =
    // true)
    // public List<Order> getListByPrice(@Param("price") double price);
    @Query("select o from Order o where o.productName = :productName")
    public List<Order> getListByProductName(@Param("productName") String productName);

    @Query("select o from Order o where o.customerName = :customerName")
    public List<Order> getListByCustomerName(@Param("customerName") String customerName);

    @Query("select o from Order o where o.price = :price")
    public List<Order> getListByPrice(@Param("price") double price);

}
