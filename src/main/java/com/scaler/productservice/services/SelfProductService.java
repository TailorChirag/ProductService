package com.scaler.productservice.services;

import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {

        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()){
            throw new ProductNotFoundException("Porduct with id " + id + " not found");
        }

        Product product = productOptional.get();
        return product;
    }

    @Override
    public List<Product> getAllProduct() throws ProductNotFoundException {

        if (productRepository.findAll().isEmpty()){
            throw new ProductNotFoundException(" kuch bhi nahi mila re baba ");
        }

        return productRepository.findAll();

    }

    @Override
    public Product addNewProduct(Product product) {

        Optional<Category> optionalCategory = categoryRepository.findByName(product.getCategory().getName());

        if(optionalCategory.isEmpty()){
            product.setCategory(categoryRepository.save(product.getCategory()));
        }else{
            product.setCategory(optionalCategory.get());
        }

        return productRepository.save(product);
    }

    @Override
    public Product putProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id " + id + " ni mila raha re baba");
        }

        Product updatedProduct = optionalProduct.get();

        if(product.getTitle() != null){
            updatedProduct.setTitle(product.getTitle());
        }

        if(product.getDescription() != null){
            updatedProduct.setDescription(product.getDescription());
        }

        if (product.getPrice() != null){
            updatedProduct.setPrice(product.getPrice());
        }

        if(product.getImageUrl() != null){
            updatedProduct.setImageUrl(product.getImageUrl());
        }

        return productRepository.save(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
