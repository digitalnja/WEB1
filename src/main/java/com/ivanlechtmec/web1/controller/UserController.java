package com.ivanlechtmec.web1.controller;

import com.ivanlechtmec.web1.dto.UserDTO;
import com.ivanlechtmec.web1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/api/v1")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/list_users")
    public List<UserDTO> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getById(id);
    }
}
