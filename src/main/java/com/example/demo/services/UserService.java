package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<User>> getAllUserList() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public ResponseEntity<User> getSingleUser(String userId) {
        try {
            Optional<User> getUser = userRepository.findById(userId);
            return getUser.map(user -> ResponseEntity.status(HttpStatus.OK).body(user)).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
