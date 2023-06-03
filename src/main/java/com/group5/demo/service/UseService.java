package com.group5.demo.service;

import com.group5.demo.entity.Use;
import com.group5.demo.mapper.UseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseService {
    @Autowired
    private UseMapper mapper;

    public Integer insert (Use use){
        return mapper.insert(use);
    }

    public List<Use> findAll(){
        return mapper.findAllUses();
    }
}
