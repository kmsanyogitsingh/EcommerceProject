package com.example.ecommerce1.serviceinterface;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.ecommerce1.Entity.Customer;
import com.example.ecommerce1.Entity.Product;

@Service
public interface CustomerImpl {
    public List<Customer> getAllData();

    public Customer addCustomer(@RequestBody Customer customer);

    public Optional<Customer> getCustomerById(@PathVariable int id);

    public String deleteCustomerById(@PathVariable int id);

    public void deleteCustomer();

    public Customer modifyCustomer(@RequestBody Customer customer, @PathVariable int id);

    public Customer getDataPartialById(@PathVariable int id);

    public List<Product> getAllProduct();

    public Customer getProductByName(@RequestBody Product product);

    public Product getProductByCategory(@RequestBody Product product);
}
