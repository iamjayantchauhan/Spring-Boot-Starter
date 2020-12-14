package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> createUser(User user) {
        Object dbObject = userRepository.save(user);
        User user1 = new ObjectMapper().convertValue(dbObject, User.class);
        return ResponseEntity.ok(user1);
    }
}
