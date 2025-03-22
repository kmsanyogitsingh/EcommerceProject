package com.example.ecommerce1.serviceinterface;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ecommerce1.entity.Product;
import com.example.ecommerce1.entity.Vendor;

@Service
public interface VendorImpl {

    public List<Vendor> getAllData();

    public Optional<Vendor> getVendorById(@PathVariable int id);

    public Vendor addVendor(@RequestBody Vendor vendor);

    public void deleteAllVendor();

    public String deleteVendorById(@PathVariable int id);

    public Vendor modifyVendor(@RequestBody Vendor vendor, @PathVariable int id);

    public Map<String, Object> getDataPartialById(@PathVariable int id);

    public Product addProduct(@RequestBody Product product);

    public List<Product> getAllProduct();

    public String deleteProduct(@PathVariable int id);

}
