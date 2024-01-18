package com.scaler.productservice.services;

import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotFoundException;

    List<Product> getAllProduct();

    Product addNewProduct(Product product);

    Product putProduct(Long id, Product product);

    Product patchProduct(Long id, Product product);

    void deleteProduct(Long id);
}
