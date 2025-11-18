package com.kaylee.application.SpringApplication.controller;

import com.kaylee.application.SpringApplication.model.User;
import com.kaylee.application.SpringApplication.repository.UserRepository;
import com.kaylee.application.SpringApplication.config.SecurityConfig.passwordEncoder;
import com.kaylee.application.SpringApplication.dto.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("This email is already registered.");
        }

        user.setEmail(userDetails.getEmail());
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        user.setName(userDetails.getName());
        user.setAge(userDetails.getAge());
        user.setWeight(userDetails.getWeight());
        user.setHeight(userDetails.getHeight());

        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());

        if (user == null) {
            throw new RuntimeException("This email has not been registered yet.");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }

        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User userDetails) {
        if (userRepository.findByEmail(user.getEmail()) == null) {
            throw new RuntimeException("This email has not been registered yet.");
        }

        user.setEmail(userDetails.getEmail());
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        user.setName(userDetails.getName());
        user.setAge(userDetails.getAge());
        user.setWeight(userDetails.getWeight());
        user.setHeight(userDetails.getHeight());

        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
