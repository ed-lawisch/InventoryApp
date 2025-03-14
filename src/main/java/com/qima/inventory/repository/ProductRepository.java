package com.qima.inventory.repository;

import com.qima.inventory.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(String categoryName, Sort sort);

    List<Product> findByNameContainingIgnoreCase(String keyword);
}
