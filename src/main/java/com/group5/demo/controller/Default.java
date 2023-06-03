package com.group5.demo.controller;

import com.group5.demo.entity.Resp;
import com.group5.demo.entity.User;
import com.group5.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Default {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService service;

    @GetMapping("/check")
    public Resp<String> check(@CurrentSecurityContext(expression="authentication") Authentication authentication) {
        if(authentication.getName() != "anonymousUser"){
            return Resp.scusess(authentication.getName());
        }
        return Resp.fail("403","UnAuthenticated");
    }

    @PostMapping("/register")
    public User regi(@RequestBody User user){
        String psd = passwordEncoder.encode(user.password);
        User test =  new User(user.name, psd, "Admin",user.Address, user.phone, user.email);
        service.insert(test);
        return  test;
    }

    @GetMapping("/getAllUser")
    @PreAuthorize("hasRole('Admin')")
    public List<User> findAll(){
        return service.findAll();
    }
}