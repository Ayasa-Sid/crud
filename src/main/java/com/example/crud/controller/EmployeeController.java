package com.example.crud.controller;

import com.example.crud.entity.Product;
import com.example.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/product/v3")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return this.productService.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> findALLProduct() {
        return this.productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id) {
        return this.productService.getProductsById(id);
    }


    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return this.productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        try {
            this.productService.deleteProduct(id);
            return new ResponseEntity<>("delete done", HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>("delete not done", HttpStatus.BAD_REQUEST);
        }
    }
}