package com.group5.demo.controller;

import com.group5.demo.entity.Material;
import com.group5.demo.entity.User;
import com.group5.demo.service.MaterialService;
import com.group5.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
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
    public Authentication check(@CurrentSecurityContext(expression="authentication") Authentication authentication) {
        return authentication;
    }

    @PostMapping("/register")
    public User regi(@RequestBody User user){
        String psd = passwordEncoder.encode(user.password);
        User test =  new User(user.name, psd, "Admin");
        service.insert(test);
        return  test;
    }

}