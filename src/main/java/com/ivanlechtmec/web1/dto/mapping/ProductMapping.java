package com.ivanlechtmec.web1.dto.mapping;

import com.ivanlechtmec.web1.dto.ProductDTO;
import com.ivanlechtmec.web1.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapping {
    @Mapping(source = "name", target = "productName")
    @Mapping(target = "userName", expression = "java(product.getUserOwn().getName())")
    ProductDTO mapProdToDTO(Product product);
}
