package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("select p.id as id,p.title as title from Product p where p.id = :id")
    List<ProductWithIdAndTitle> someMethod(@Param("id") Long id );

    @Query(value = "select * from product where id = 202",nativeQuery = true)
    List<Product> someMethod2();

    ;
}
