package com.scaler.productservice;

import com.scaler.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    @Transactional
//    @Commit
//    void testQueries(){
//        productRepository.findByTitleContaining("Chirag");
//        productRepository.deleteByTitle("chirag");
//    }


}
