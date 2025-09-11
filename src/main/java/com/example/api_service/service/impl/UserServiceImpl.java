package com.example.api_service.service.impl;

import com.example.api_service.entity.UserEntity;
import com.example.api_service.exception.UserAlreadyExistsException;
import com.example.api_service.repository.UserRepository;
import com.example.api_service.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        boolean existsByEmail = userRepository.existsByEmail(userEntity.getEmail());
        if (existsByEmail) {
            throw new UserAlreadyExistsException("User already exists with email: " + userEntity.getEmail());
        }
        return userRepository.save(userEntity);
    }
}
