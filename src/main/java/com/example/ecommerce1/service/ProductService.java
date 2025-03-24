package com.example.ecommerce1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce1.entity.Product;
import com.example.ecommerce1.repository.ProductReposit;
import com.example.ecommerce1.repository.VendorReposit;
import com.example.ecommerce1.serviceinterface.ProductImpl;

import java.util.List;

@Service
public class ProductService implements ProductImpl {

    @Autowired
    ProductReposit pr;
    @Autowired
    VendorReposit vr;

    @Override
    public List<Product> getAllProduct() {
        return pr.findAll();
    }

    @Override
    public List<Product> getProductByName(Product product) {

        throw new UnsupportedOperationException("Unimplemented method 'getProductByName'");
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return pr.getProductByCategory(category);
    }

    @Override
    public List<Product> getProductByNameAndCategory(Product data) {

        throw new UnsupportedOperationException("Unimplemented method 'getProductByNameAndCategory'");
    }

    @Override
    public Product getProductById(int id) {

        throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
    }

}
