package com.example.api_service.controller;

import com.example.api_service.entity.UserEntity;
import com.example.api_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("create/user")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        return new ResponseEntity<>(userService.createUser(userEntity), HttpStatus.CREATED);
    }

}
