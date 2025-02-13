package com.qima.inventory.controller.mvc;

import com.qima.inventory.model.Product;
import com.qima.inventory.service.CategoryService;
import com.qima.inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/")
    public String getAllProducts(Model model) {
        // since there is a service to fetch products and add them to the model
        model.addAttribute("products", productService.getAllProducts());
        return "products"; // This will render the products.html template
    }

    // Show form to add a new product
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product-form";
    }

    // Process form to add a new product
}*/

@Controller
@RequestMapping("/products")
public class ProductPageController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductPageController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getAllProducts(@RequestParam(value = "sortBy", required = false, defaultValue = "name") String sortBy,
                                 @RequestParam(value = "keyword", required = false) String keyword,
                                 Model model) {
        List<Product> products;

        if (keyword != null && !keyword.isEmpty()) {
            products = productService.filterProducts(keyword);
        } else {
            products = productService.getAllProducts();
        }

        if (sortBy != null && !sortBy.isEmpty()) {
            products = products.stream()
                    .sorted((p1, p2) -> {
                        if (sortBy.equals("name")) {
                            return p1.getName().compareToIgnoreCase(p2.getName());
                        } else if (sortBy.equals("price")) {
                            return p1.getPrice().compareTo(p2.getPrice());
                        } else if (sortBy.equals("category")) {
                            return p1.getCategory().getName().compareToIgnoreCase(p2.getCategory().getName());
                        }
                        return 0;
                    })
                    .toList();
        }

        model.addAttribute("products", products);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("keyword", keyword);

        return "products";

    }

            // Show form to add a new product
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product-form";
    }

    // Process form to add a new product
    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "product-form";
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // Show form to edit an existing product
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product-form";
    }

    // Process form to update the product
    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "product-form";
        }
        product.setId(id);
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // Delete a product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
