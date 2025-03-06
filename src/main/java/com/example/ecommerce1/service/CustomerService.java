
package com.example.ecommerce1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce1.Entity.Customer;
import com.example.ecommerce1.Entity.Product;
import com.example.ecommerce1.repository.CustomerReposit;
import com.example.ecommerce1.serviceinterface.CustomerImpl;

@Service
public class CustomerService implements CustomerImpl {
    @Autowired
    CustomerReposit cr;

    @Override
    public List<Customer> getAllData() {
        return cr.findAll();
    }

    @Override
    
    public Optional<Customer> getCustomerById(int id) {
        return cr.findById(id);
    }

    @Override
    public Customer addCustomer(Customer customer) {

        return cr.save(customer);
    }

    @Override
    public String deleteCustomerById(int id) {
        if (cr.existsById(id)) {
            cr.deleteById(id);
            return "Data is Deleted";
        } else {
            throw new RuntimeException("Id not found : " + id);
        }

    }

    @Override
    public void deleteCustomer() {
        cr.deleteAll();
    }

    @Override
  
    public Customer modifyCustomer(Customer customer, int id) {
        Optional<Customer> exits = cr.findById(id);
        if (exits.isPresent()) {
            Customer cust = exits.get();

            cust.setName(customer.getName());
            cust.setEmail(customer.getEmail());
            cust.setContact(customer.getContact());
            cust.setAge(customer.getAge());
            cust.setAddress(customer.getAddress());
            cust.setGender(customer.getGender());
            cust.setPassword(customer.getPassword());
            return cr.save(cust);

        } else {
            throw new RuntimeException("Id not found: " + id);
        }

    }

    @Override
    public Customer getDataPartialById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDataPartialById'");
    }

    @Override
    public List<Product> getAllProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProduct'");
    }

    @Override
    public Customer getProductByName(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductByName'");
    }

    @Override
    public Product getProductByCategory(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductByCategory'");
    }
}
