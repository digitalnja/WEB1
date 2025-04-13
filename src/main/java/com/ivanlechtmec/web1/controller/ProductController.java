package com.ivanlechtmec.web1.controller;

import com.ivanlechtmec.web1.dto.ProductDTO;
import com.ivanlechtmec.web1.model.Product;
import com.ivanlechtmec.web1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/api/v1")
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @GetMapping("/list")
    public List<ProductDTO> getList(){
        return productService.listProducts();
    }





    @GetMapping("/filter")
    public List<Product> getProductsByName(@RequestParam String name){
        return productService.getProductByNamePrefix(name);
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
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
