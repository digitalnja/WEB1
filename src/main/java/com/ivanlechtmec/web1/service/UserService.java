package com.ivanlechtmec.web1.service;

import com.ivanlechtmec.web1.dto.UserDTO;
import com.ivanlechtmec.web1.dto.mapping.UserMapping;
import com.ivanlechtmec.web1.logger.LoggerInfo;
import com.ivanlechtmec.web1.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapping userMapping;
    private final LoggerInfo loggerInfo;

    public UserService(UserRepository userRepository, UserMapping userMapping, LoggerInfo loggerInfo) {
        this.userRepository = userRepository;
        this.userMapping = userMapping;
        this.loggerInfo = loggerInfo;
    }

    @Transactional
    public List<UserDTO> getAll(){
        loggerInfo.info("Вызов метода");
        return userRepository.findAll().stream().map(userMapping::mapUserToDTO).toList();

    }

    public UserDTO getById(Long id){
        return userRepository.findById(id).map(userMapping::mapUserToDTO)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Пользователь с ID %d не найдет", id)));
    }
}
