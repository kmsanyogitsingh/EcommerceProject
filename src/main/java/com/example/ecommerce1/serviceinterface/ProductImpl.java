package com.example.ecommerce1.serviceinterface;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ecommerce1.entity.Product;

@Service
public interface ProductImpl {

    public List<Product> getAllProduct();

    public List<Product> getProductByName(Product product);

    public List<Product> getProductByCategory(String category);

    public List<Product> getProductByNameAndCategory(Product data);

    public Product getProductById(@PathVariable int id);

}
