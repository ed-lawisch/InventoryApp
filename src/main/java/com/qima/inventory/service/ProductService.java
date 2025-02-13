package com.qima.inventory.service;

import com.qima.inventory.model.Product;
import com.qima.inventory.repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProductsSorted(String sortBy) {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
    }

    public List<Product> filterProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategory(String categoryName, Sort sort) {
        return productRepository.findByCategoryName(categoryName, sort);
    }
}