package com.example.learsaprk2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learsaprk2.config.JwtUtil;
import com.example.learsaprk2.entity.User;
import com.example.learsaprk2.repository.UserRepository;


import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(HttpServletRequest request) {
        String email = jwtUtil.extractEmail(request.getHeader("Authorization").substring(7));
        User user = userRepository.findByEmail(email).orElseThrow();
        return ResponseEntity.ok(user);
    }
}
