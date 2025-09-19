package com.example.api_service.controller;

import com.example.api_service.entity.UserEntity;
import com.example.api_service.exception.UserNotFoundException;
import com.example.api_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${app.name}")
    private String appName;

    @Autowired
    private UserService userService;

    @GetMapping("app/info")
    public String getAppInfo() {
        return appName;
    }

    @PostMapping("create/user")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        UserEntity userEntityResponse = userService.createUser(userEntity);
        logger.info("Newly created user response: {}", userEntityResponse);
        return new ResponseEntity<>(userEntityResponse, HttpStatus.CREATED);
    }

    @GetMapping("all/users")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> usersList = userService.getAllUsers();
        if (usersList.isEmpty()) {
            throw new UserNotFoundException("No users found in database");
        }
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

}
