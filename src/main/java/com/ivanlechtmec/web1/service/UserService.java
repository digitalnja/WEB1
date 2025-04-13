package com.ivanlechtmec.web1.service;

import com.ivanlechtmec.web1.dto.UserDTO;
import com.ivanlechtmec.web1.dto.mapping.UserMapping;
import com.ivanlechtmec.web1.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapping userMapping;

    public UserService(UserRepository userRepository, UserMapping userMapping) {
        this.userRepository = userRepository;
        this.userMapping = userMapping;
    }

    public List<UserDTO> getAll(){
        return userRepository.findAll().stream().map(userMapping::mapUserToDTO).toList();
    }

    public UserDTO getById(Long id){
        return userRepository.findById(id).map(userMapping::mapUserToDTO)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Пользователь с ID %d не найдет", id)));
    }
}
