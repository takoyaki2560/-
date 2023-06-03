package com.group5.demo.controller;

import com.group5.demo.entity.Use;
import com.group5.demo.service.UseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Use")
public class UseController {

    @Autowired
    private UseService service;

    @PostMapping("/add")
    public Use add(@RequestBody Use use){
        Use newUse =  new Use(use.INo,use.pId,use.amount);
        service.insert(newUse);
        return  newUse;
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('Admin')")
    public List<Use> findAll(){
        return service.findAll();
    }
}