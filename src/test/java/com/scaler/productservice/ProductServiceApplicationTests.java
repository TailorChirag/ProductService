package com.scaler.productservice;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.ProductRepository;
import com.scaler.productservice.repositories.projections.ProductWithIdAndTitle;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {

//    @Autowired
//    private ProductRepository productRepository;

//    @Test
//    void contextLoads() {
//    }

//    @Test
//    @Transactional
//    @Commit
//    void testQueries(){
////        productRepository.findByTitleContaining("Chirag");
////        productRepository.deleteByTitle("chirag");
//        List<ProductWithIdAndTitle> product = productRepository.someMethod(203L);
//
//        for (ProductWithIdAndTitle products : product) {
//            System.out.println(products.getId());
//            System.out.println(products.getTitle());
//        }
//
//        List<Product> product2 = productRepository.someMethod2();
//    }


}
