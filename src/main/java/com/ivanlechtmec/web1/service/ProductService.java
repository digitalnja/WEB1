package com.ivanlechtmec.web1.service;

import com.ivanlechtmec.web1.model.Product;
import com.ivanlechtmec.web1.repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductByNamePrefix(String prefix){
        return productRepository.getProductByName(prefix);
    }

    public Product createProduct(String name, String details, Integer price){
        return productRepository.save(
                Product.builder()
                        .name(name)
                        .details(details)
                        .price(price)
                        .build()
        );
    }

    public List<Product> getAllProducts(){
        return  productRepository.findAll();
    }
    @Transactional
    public Product updateProduct(Long id, Product updatedProduct){
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("Товар с таким \"%d\" не найден", id)));
        productRepository.delete(product);
        return productRepository.save(
                Product.builder()
                        .id(updatedProduct.getId())
                        .name(updatedProduct.getName())
                        .details(updatedProduct.getDetails())
                        .price(updatedProduct.getPrice())
                        .build()
        );
    }

    public String deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("Товар с таким \"%d\" не найден", id)));
        productRepository.delete(product);
        return "Товар успешно удален";
    }



}
