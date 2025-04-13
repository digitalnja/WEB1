package com.ivanlechtmec.web1.dto;

import lombok.Data;

import java.util.List;
@Data
public class UserDTO {
    private String userName;
    private String email;
    private List<ProductDTO> orders;
}
