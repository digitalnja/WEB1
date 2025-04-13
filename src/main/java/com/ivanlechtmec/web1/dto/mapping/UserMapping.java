package com.ivanlechtmec.web1.dto.mapping;

import com.ivanlechtmec.web1.dto.UserDTO;
import com.ivanlechtmec.web1.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductMapping.class)
public interface UserMapping {
    @Mapping(source = "name", target = "userName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "products", target = "orders")
    UserDTO mapUserToDTO(User user);
}
