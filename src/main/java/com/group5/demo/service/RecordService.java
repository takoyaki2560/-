package com.group5.demo.service;

import com.group5.demo.entity.Record;
import com.group5.demo.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordMapper mapper;

    public Integer insert (Record record){
        return mapper.insert(record);
    }

    public List<Record> findAll(){
        return mapper.findAllRecords();
    }
}
