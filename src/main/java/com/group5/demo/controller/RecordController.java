package com.group5.demo.controller;

import com.group5.demo.entity.Record;
import com.group5.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Record")
public class RecordController {

    @Autowired
    private RecordService service;

    @PostMapping("/add")
    public Record add(@RequestBody Record record){
        Record newRecord =  new Record(record.pId, record.tId,record.salePrice,record.amount);
        service.insert(newRecord);
        return  newRecord;
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('Admin')")
    public List<Record> findAll(){
        return service.findAll();
    }
}