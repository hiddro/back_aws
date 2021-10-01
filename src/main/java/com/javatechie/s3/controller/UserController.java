package com.javatechie.s3.controller;

import com.javatechie.s3.entity.User;
import com.javatechie.s3.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public User findUser(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User no disponible"));
        return user;
    }
}
