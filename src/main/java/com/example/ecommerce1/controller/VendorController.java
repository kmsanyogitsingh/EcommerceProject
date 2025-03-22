package com.example.ecommerce1.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce1.entity.Product;
import com.example.ecommerce1.entity.Vendor;
import com.example.ecommerce1.service.VendorService;

@RestController
@RequestMapping("/auth/vendor")
public class VendorController {

    @Autowired
    VendorService vs;

    @GetMapping("/allvendor")
    public List<Vendor> getAllVendor() {
        return vs.getAllData();
    }

    @GetMapping("/allvendorbyid/{id}")
    public Optional<Vendor> getVendorById(@PathVariable int id) {

        Optional<Vendor> check = vs.getVendorById(id);

        if (check.isPresent()) {
            return check;
        } else {
            throw new RuntimeException("Vendor Id not found: " + id);
        }
    }

    @PostMapping("/addvendor")
    public Vendor addVendor(@RequestBody Vendor vendor) {
        return vs.addVendor(vendor);
    }

    @DeleteMapping("/deletevendor")
    public String deleteVendor() {
        vs.deleteAllVendor();
        return "All data is Deleted";
    }

    @DeleteMapping("/deletevendorbyid/{id}")
    public String deleteVendorById(@PathVariable int id) {
        return vs.deleteVendorById(id);
    }

    @PutMapping("/modifyvendor/{id}")
    public Vendor modifyVendor(@RequestBody Vendor vendor, @PathVariable int id) {
        return vs.modifyVendor(vendor, id);
    }

    @GetMapping("/getvendorpartial/{id}")
    public Map<String, Object> getPartialDataVedor(@PathVariable int id) {

        return vs.getDataPartialById(id);

    }

    @GetMapping("/getallproduct")
    public List<Product> getAllProduct() {
        return vs.getAllProduct();
    }

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product) {
        return vs.addProduct(product);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        return vs.deleteProduct(id);
    }
}
