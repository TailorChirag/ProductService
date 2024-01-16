package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {
        return new Product();
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product) {
        Product  product1 = new Product();
        product1.setTitle("New Product");
        return product1;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
    }



}
