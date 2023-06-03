package com.group5.demo.controller;

import com.group5.demo.entity.User;
import com.group5.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Default {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService service;
    @GetMapping("/check")
    public String check() {
        return "check";
    }

    @PostMapping("/register")
    public User regi(@RequestBody User user){
        String psd = passwordEncoder.encode(user.password);
        User test =  new User(user.name, psd, "Admin");
        service.insert(test);
        return  test;
    }
}