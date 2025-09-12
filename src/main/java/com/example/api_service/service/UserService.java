package com.example.api_service.service;

import com.example.api_service.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity userEntity);

    List<UserEntity> getAllUsers();
}
