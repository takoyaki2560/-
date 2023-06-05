package com.group5.demo.controller;

import com.group5.demo.entity.Material;
import com.group5.demo.entity.Product;
import com.group5.demo.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Material")
public class MaterialController {

    @Autowired
    private MaterialService service;

    @PostMapping("/add")
    public Material add(@RequestBody Material material){
        Material newMaterial =  new Material(material.mType,material.mName,material.mNum);
        service.insert(newMaterial);
        return  newMaterial;
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('Admin')")
    public List<Material> findAll(){
        return service.findAll();
    }

    @GetMapping("/findMaterialNameById")
    @PreAuthorize("hasRole('Admin')")
    public Material findNameByID(@RequestParam String id){
        return  service.findNameByID(id);
    }
}