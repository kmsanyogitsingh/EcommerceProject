package com.example.ecommerce1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce1.entity.Order;
import com.example.ecommerce1.service.OrderService;

@RestController
@RequestMapping("/customer/order")
public class OrderController {

    @Autowired
    OrderService os;

    @GetMapping("/getorder")
    public List<Order> getAllOrder() {
        return os.getAllList();
    }

    @PostMapping("/placeorder")
    public Order placeOrder(@RequestBody Order order) {
        return os.placeOrder(order);
    }

    @GetMapping("/getorderbyproduct/{productName}")
    public List<Order> getListByProductName(@PathVariable String productName) {
        return os.getListByProductName(productName);
    }

    @GetMapping("/getorderbycustomer/{customerName}")
    public List<Order> getListByCustomerName(@PathVariable String customerName) {
        return os.getListByCustomerName(customerName);
    }

    @GetMapping("/getorderbyprice/{price}")
    public List<Order> getListByPrice(@PathVariable double price) {
        return os.getListByPrice(price);
    }

    @DeleteMapping("/deleteorder/{id}")
    public String deleteOrder(@PathVariable int id) {
        return os.deleteOrder(id);
    }

    @PutMapping("/modifyorder/{id}")
    public Order modifyOrder(@RequestBody Order order, @PathVariable int id) {
        return os.modifyOrder(order, id);
    }
}
