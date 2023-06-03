package com.group5.demo.service;

import com.group5.demo.mapper.MaterialMapper;
import com.group5.demo.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    private MaterialMapper mapper;

    public Integer insert (Material material){
        return mapper.insert(material);
    }

    public List<Material> findAll(){
        return mapper.findAllMaterials();
    }
}
