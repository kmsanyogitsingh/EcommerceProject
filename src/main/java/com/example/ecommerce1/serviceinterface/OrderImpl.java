package com.example.ecommerce1.serviceinterface;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ecommerce1.entity.Order;

@Service
public interface OrderImpl {
    public List<Order> getAllList();

    public List<Order> getListByProductName(@PathVariable String ProductName);

    public List<Order> getListByCustomerName(@PathVariable String CustomerName);

    public Order getListById(@PathVariable int id);

    public List<Order> getListByPrice(@PathVariable double price);

    public Order placeOrder(@RequestBody Order order);

    public Order modifyOrder(@RequestBody Order order, @PathVariable int id);

    public String deleteOrder(@PathVariable int id);
}
