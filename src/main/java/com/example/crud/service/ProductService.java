package com.example.crud.service;

import com.example.crud.entity.Product;
import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return this.repository.save(product);
    }

    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }


    public Product getProductsById(int id) {
        return this.repository.findById(id).orElse(null);
    }

    public void deleteProduct(int id) {
        this.repository.deleteById(id);
    }

    public Product updateProduct(Product product) {
        return this.repository.save(product);
    }
}