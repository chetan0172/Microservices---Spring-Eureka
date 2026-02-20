package com.techie.userservice.controller;

import com.techie.userservice.entity.User;
import com.techie.userservice.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 🔹 Create User
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 🔹 Get All Users
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}