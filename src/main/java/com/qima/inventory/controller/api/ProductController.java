package com.qima.inventory.controller.api;

import com.qima.inventory.model.Product;
import com.qima.inventory.service.ProductService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/filter")
    public List<Product> getProductsByCategory(@RequestParam String categoryName, @RequestParam String sortBy) {
        Sort sort = Sort.by(sortBy).ascending();
        return productService.getProductsByCategory(categoryName, sort);
    }

    //To make it simple for this demo, it is returning the Entity itself, otherwise it should be a DTO
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    //To make it simple for this demo, it is returning the Entity itself, otherwise it should be a DTO
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //To make it simple for this demo, it is returning the Entity itself, otherwise it should be a DTO
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);

    }
}