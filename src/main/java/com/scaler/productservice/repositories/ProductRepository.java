package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsById(Long id);

    List<Product> findByTitleContaining(String word);

    long deleteByTitle(String title);

    Optional<Product> findById(Long id);

    Product save(Product product);

    List<Product> findAll();

    void deleteById(Long id);

    ;
}
