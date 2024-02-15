package com.scaler.productservice.controllers;

import com.scaler.productservice.commons.AuthenticationCommons;
import com.scaler.productservice.dtos.UserDto;
import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.ProductRepository;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private ProductRepository productRepository;
    private AuthenticationCommons authenticationCommons;


    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService,
                             ProductRepository productRepository,AuthenticationCommons authenticationCommons){
        this.productService = productService;
        this.productRepository = productRepository;
        this.authenticationCommons = authenticationCommons;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestHeader("AuthenticationToken") String token) throws ProductNotFoundException {

        UserDto userDto = authenticationCommons.validateToken(token);

        if(userDto == null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        ResponseEntity<List<Product>> response =
                new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK);
    }

    @PostMapping()
    public Product addNewProduct( @RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.putProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException{
        if (!productRepository.existsById(id) ){
            throw new ProductNotFoundException("ider koi product nahi mila " + id + " esi koi id nahi hai");
        }
        productService.deleteProduct(id);
        System.out.println("product deleted" + id );


    }



}
