package com.example.ecommerce1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce1.Entity.Customer;
import com.example.ecommerce1.service.CustomerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth/customer")
public class CustomerControlller {
    @Autowired
    CustomerService cs;

    @GetMapping("/getcustomer")
    public List<Customer> getAllData() {
        return cs.getAllData();
    }

    @GetMapping("/getcustomer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable int id) {
        Optional<Customer> exist = cs.getCustomerById(id);

        if (exist.isPresent()) {

            return exist;

        } else {
            throw new RuntimeException("ID does not Exist: " + id);
        }

    }

    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return cs.addCustomer(customer);

    }

    @DeleteMapping("deletecustomer/{id}")
    public String deleteByCustomerId(@PathVariable int id) {
        return cs.deleteCustomerById(id);
    }

    @DeleteMapping("AlldeleteCustomer")
    public String deleteAll() {
        cs.deleteCustomer();
        return " Customer Details is deleted";
    }

    @PutMapping("modifycustomer/{id}")
    public Customer modifyCustomer(@PathVariable int id, @RequestBody Customer update) {
        return cs.modifyCustomer(update, id);
    }
}
