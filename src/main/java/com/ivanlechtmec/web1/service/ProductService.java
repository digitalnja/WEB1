package com.ivanlechtmec.web1.service;

import com.ivanlechtmec.web1.dto.ProductDTO;
import com.ivanlechtmec.web1.dto.mapping.ProductMapping;
import com.ivanlechtmec.web1.model.Product;
import com.ivanlechtmec.web1.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapping productMapping;
    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapping productMapping) {
        this.productRepository = productRepository;
        this.productMapping = productMapping;
    }

    public List<ProductDTO> listProducts(){
        return productRepository.findAll().stream().map(productMapping::mapProdToDTO).toList();
    }

    public ProductDTO getProductById(Long id){
        return productRepository.findById(id).map(productMapping::mapProdToDTO).orElseThrow
                (() -> new EntityNotFoundException(String.format("Товар с ID %d не найдет", id)));

    }

    public List<Product> getProductByNamePrefix(String prefix){
        return productRepository.getProductByName(prefix);
    }
    @Transactional
    public Product createProduct(Product product){
        return productRepository.save(
                Product.builder()
                        .name(product.getName())
                        .details(product.getDetails())
                        .price(product.getPrice())
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
    @Transactional
    public String deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("Товар с таким \"%d\" не найден", id)));
        productRepository.delete(product);
        return "Товар успешно удален";
    }



}
