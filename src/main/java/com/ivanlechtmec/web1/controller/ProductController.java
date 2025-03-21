package com.ivanlechtmec.web1.controller;

import com.ivanlechtmec.web1.model.Product;
import com.ivanlechtmec.web1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public List<Product> getProductsByName(@RequestParam String name){
        return productService.getProductByNamePrefix(name);
    }

    @PostMapping("/create")
    public Product createProduct(@RequestParam String name,
                                 @RequestParam String details,
                                 @RequestParam Integer price){
        return productService.createProduct(name,details,price);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct){
        return productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
