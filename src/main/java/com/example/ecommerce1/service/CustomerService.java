package com.example.ecommerce1.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce1.entity.Customer;
import com.example.ecommerce1.entity.Product;
import com.example.ecommerce1.repository.CustomerReposit;
import com.example.ecommerce1.repository.ProductReposit;
import com.example.ecommerce1.serviceinterface.CustomerImpl;
 @Service
public class CustomerService implements CustomerImpl{

    @Autowired 
    CustomerReposit cr;
    @Autowired
    ProductReposit pr;

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
    public void deleteAllCustomer() {
        cr.deleteAll();
    }

    @Override
    public String deleteCustomerById(int id) {
       if(cr.existsById(id)) {
        cr.deleteById(id);
        return "Data is deleted";
       }
       else {
        throw new RuntimeException("ID does not exist:"+ id);
       }
    }

    @Override
    public Customer modifyCustomer(Customer customer, int id) {
        Optional<Customer> exist = cr.findById(id);

        if(exist.isPresent()) {
            Customer con = exist.get();

            con.setName(customer.getName() != null ?  customer.getName(): con.getName());
            con.setEmail(customer.getEmail()!= null ?  customer.getEmail(): con.getEmail());
            con.setAddress(customer.getAddress()!= null ?  customer.getAddress(): con.getAddress());
            con.setContact(customer.getContact()!= null ?  customer.getContact(): con.getContact());
            con.setAge(customer.getAge()> 0 ?  customer.getAge(): con.getAge());
            con.setPassword(customer.getPassword()!= null ?  customer.getPassword(): con.getPassword());
            con.setGender(customer.getGender()!= null ?  customer.getGender(): con.getGender());

            return cr.save(con);
        }
        else {
            throw new RuntimeException("Id does not exists");
        }
    }

    @Override
    public List<Object[]> getDataPartialById(int id) {
        return cr.getPartialData(id);
       
    }

    @Override
    public List<Product> getAllProduct() {
        return pr.findAll();
    }

    @Override
    public List<Product> getProductByName(String  name) {
        return pr.getProductByName(name);
    }

    @Override
    public List<Product> getProductByCategory(String category) {
       return pr.getProductByCategory(category);
    }

    public void deleteCustomer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
    }
    
}

