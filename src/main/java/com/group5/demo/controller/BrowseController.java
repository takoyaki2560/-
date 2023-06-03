package com.group5.demo.controller;

import com.group5.demo.entity.Browse;
import com.group5.demo.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Browse")
public class BrowseController {

    @Autowired
    private BrowseService service;

    @PostMapping("/add")
    public Browse add(@RequestBody Browse browse){
        Browse newBrowse =  new Browse(browse.uid,browse.pid,browse.browseTime);
        service.insert(newBrowse);
        return  newBrowse;
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('Admin')")
    public List<Browse> findAll(){
        return service.findAll();
    }
}