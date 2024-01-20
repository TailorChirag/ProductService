package com.scaler.productservice.services;

import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotFoundException;

    List<Product> getAllProduct();

    Product addNewProduct(Product product);

    Product putProduct(Long id, Product product);

    Product updateProduct(Long id, Product product) throws ProductNotFoundException;

    boolean deleteProduct(Long id);
}
