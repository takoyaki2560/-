package com.group5.demo.service;

import com.group5.demo.entity.Browse;
import com.group5.demo.mapper.BrowseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowseService {
    @Autowired
    private BrowseMapper mapper;

    public Integer insert (Browse browse){
        return mapper.insert(browse);
    }

    public List<Browse> findAll(){
        return mapper.findAllBrowses();
    }
}
