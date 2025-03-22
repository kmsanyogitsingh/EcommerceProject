package com.example.ecommerce1.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce1.entity.Product;
import com.example.ecommerce1.entity.Vendor;
import com.example.ecommerce1.repository.ProductReposit;
import com.example.ecommerce1.repository.VendorReposit;
import com.example.ecommerce1.serviceinterface.VendorImpl;

@Service
public class VendorService implements VendorImpl {
@Autowired
    VendorReposit vr;

    @Autowired 
    ProductReposit pr;

    @Override
    public List<Vendor> getAllData() {
        return vr.findAll();
    }

    @Override
    public Optional<Vendor> getVendorById(int id) {
        return vr.findById(id);
        
    }

    @Override
    public Vendor addVendor(Vendor vendor) {
        return vr.save(vendor);
    }

    @Override
    public Vendor modifyVendor(Vendor vendor, int id) {
        Optional<Vendor> exist = vr.findById(id);

        if(exist.isPresent()) {
            Vendor con = exist.get();

            con.setName(vendor.getName() != null ?  vendor.getName(): con.getName());
            con.setEmail(vendor.getEmail()!= null ?  vendor.getEmail(): con.getEmail());
            con.setAddress(vendor.getAddress()!= null ?  vendor.getAddress(): con.getAddress());
            con.setContact(vendor.getContact()!= null ?  vendor.getContact(): con.getContact());
            con.setPassword(vendor.getPassword()!= null ?  vendor.getPassword(): con.getPassword());

            return vr.save(con);
        }
        else {
            throw new RuntimeException("Id does not exists");
        }
    }

    @Override
    public void deleteAllVendor() {
       vr.deleteAll();
    }

    @Override
    public String deleteVendorById(int id) {
        if(vr.existsById(id)) {
            vr.deleteById(id);
            return "Your data is deleted";
        }
        else {
            return "ID not found";
        }
    }


    @Override
    public Map<String, Object> getDataPartialById(int id) {

        List<Object[]> log = vr.getPartialData(id);

        if(log.isEmpty()) {
            throw new RuntimeException("Id not found"+id);
        }

        else {
            Object[] ven = log.get(0);
            Map<String, Object> mp = new LinkedHashMap<String, Object>();
            mp.put("Name : ", ven[0]);
            mp.put("Email : ", ven[1]);
            mp.put("Contact : ", ven[2]);
            mp.put("Address : ", ven[3]);

            return mp;
        }
        
    }

    
    
    @Override
    public Product addProduct(Product product) {
        return pr.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return pr.findAll();
    }

    @Override
    public String deleteProduct(int id) {
        if(pr.existsById(id)) {
            pr.deleteById(id);
            return "Your Product is deleted";
        }
        else {
            return "Not deleted yet";
        }
    }
    
}
