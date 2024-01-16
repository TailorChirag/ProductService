package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct) {
        Product product = new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setId(fakeStoreProduct.getId());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setCategory(new Category());
        product.setImageUrl(fakeStoreProduct.getImage());
        product.getCategory().setName(fakeStoreProduct.getCategory());
        return product;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
        );
        return convertFakeStoreProductToProduct(productDto);
    }
}
