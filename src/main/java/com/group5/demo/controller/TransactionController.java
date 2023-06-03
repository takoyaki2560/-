package com.group5.demo.controller;

import com.group5.demo.entity.Transaction;
import com.group5.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("/add")
    public Transaction add(@RequestBody Transaction transaction){
        Transaction newTransaction =  new Transaction(transaction.mId,transaction.transTime);
        service.insert(newTransaction);
        return  newTransaction;
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('Admin')")
    public List<Transaction> findAll(){
        return service.findAll();
    }
}