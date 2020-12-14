package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
