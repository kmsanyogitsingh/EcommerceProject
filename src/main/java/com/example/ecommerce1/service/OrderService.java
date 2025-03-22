package com.example.ecommerce1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce1.entity.Order;
import com.example.ecommerce1.repository.OrderReposit;
import com.example.ecommerce1.serviceinterface.OrderImpl;

@Service
public class OrderService implements OrderImpl {

    @Autowired
    OrderReposit or;

    @Override
    public List<Order> getAllList() {
        return or.findAll();
    }

    @Override
    public List<Order> getListByProductName(String ProductName) {
        return or.getListByProductName(ProductName);
    }

    @Override
    public List<Order> getListByCustomerName(String CustomerName) {
        return or.getListByCustomerName(CustomerName);
    }

    @Override
    public Order getListById(int id) {
        Optional<Order> check = or.findById(id);
        if (check.isPresent()) {
            Order order = check.get();
            return order;
        } else {
            throw new RuntimeException("Id not found");
        }

    }

    @Override
    public List<Order> getListByPrice(double price) {
        return or.getListByPrice(price);
    }

    @Override
    public Order placeOrder(Order order) {
        return or.save(order);
    }

    @Override
    public Order modifyOrder(Order order, int id) {
        Optional<Order> check = or.findById(id);
        if (check.isPresent()) {
            Order od = check.get();
            od.setCustomerName(order.getCustomerName());
            od.setProductName(order.getProductName());
            od.setQuantity(order.getQuantity());

            return or.save(od);
        } else {
            throw new RuntimeException("ID not found");
        }
    }

    @Override
    public String deleteOrder(int id) {
        if (or.existsById(id)) {
            or.deleteById(id);
            return "order is deleted";
        } else {
            return "Order Id not Found, Please Try again";
        }
    }

}
