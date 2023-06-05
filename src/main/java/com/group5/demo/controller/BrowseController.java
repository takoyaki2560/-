package com.group5.demo.controller;

import com.group5.demo.entity.Browse;
import com.group5.demo.entity.User;
import com.group5.demo.service.BrowseService;
import com.group5.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/Browse")
public class BrowseController {

    @Autowired
    private BrowseService service;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Browse add(@RequestBody Browse browse , @CurrentSecurityContext(expression="authentication") Authentication authentication){
        User user = userService.findOne(authentication.getName());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Browse newBrowse =  new Browse(user._id,browse.pid,timestamp);
        service.insert(newBrowse);
        return  newBrowse;
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('Admin')")
    public List<Browse> findAll(){
        return service.findAll();
    }
}