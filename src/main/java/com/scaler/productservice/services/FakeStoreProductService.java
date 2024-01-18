package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct) {
        if(fakeStoreProduct == null){
            return new Product();
        }
        Product product = new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setId(fakeStoreProduct.getId());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setCategory(new Category());
        product.setImageUrl(fakeStoreProduct.getImage());
        Category category = new Category();
//        if(category != null){
//            category.setCategoryName(fakeStoreProduct.getCategoryName());
//        }
        product.getCategory().setCategoryName(fakeStoreProduct.getCategoryName());
        return product;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {

        int a = 1 / 0;

        FakeStoreProductDto productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
        );

        if(productDto == null){
            throw  new ProductNotFoundException(
                    "Product with id " + id + " nahi mila re baba"
            );

        }
        return convertFakeStoreProductToProduct(productDto);
    }

    private FakeStoreProductDto convertProductToFakeStoreProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategoryName(product.getCategory().getCategoryName());
        fakeStoreProductDto.setImage(product.getImageUrl());
        return fakeStoreProductDto;
    }

    @Override
    public Product addNewProduct(Product product) {
        FakeStoreProductDto productDto = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
               convertProductToFakeStoreProduct(product),
                FakeStoreProductDto.class
        );
        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public Product putProduct(Long id, Product product) {

//        FakeStoreProductDto productDto = new FakeStoreProductDto();
//        productDto.setTitle(product.getTitle());
//        productDto.setPrice(product.getPrice());
//        productDto.setDescription(product.getDescription());
//        productDto.setImage(product.getImageUrl());
//        productDto.setCategory(product.getCategory().getCategoryName());
//
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(productDto, FakeStoreProductDto.class);
//        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
//                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
//        FakeStoreProductDto fakeStoreProductDto = restTemplate.execute("https://fakestoreapi.com/products" + id, HttpMethod.PUT, requestCallback, responseExtractor);
//        return convertFakeStoreProductToProduct(fakeStoreProductDto);

        HttpEntity<FakeStoreProductDto> request = restTemplate.exchange("https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                new HttpEntity<>(convertProductToFakeStoreProduct(product)),
                FakeStoreProductDto.class);
        return convertFakeStoreProductToProduct(request.getBody());
    }

    @Override
    public Product patchProduct(Long id, Product product) {

        FakeStoreProductDto productDto = restTemplate.patchForObject(
                "https://fakestoreapi.com/products/" + id,
                convertProductToFakeStoreProduct(product),
                FakeStoreProductDto.class
        );
        return convertFakeStoreProductToProduct(productDto);

    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
    }

    @Override
    public List<Product> getAllProduct() {
        FakeStoreProductDto[] productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : productDto) {
            products.add(convertFakeStoreProductToProduct(fakeStoreProductDto));
        }
        return products;


    }
}
