package com.group5.demo.controller;

import com.group5.demo.entity.Transaction;
import com.group5.demo.entity.User;
import com.group5.demo.service.TransactionService;
import com.group5.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/Transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Transaction add(@RequestBody Transaction transaction){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Transaction newTransaction =  new Transaction(transaction.mId,timestamp);
        service.insert(newTransaction);
        return  newTransaction;
    }

    @GetMapping("/buy")
    public Transaction buy(@CurrentSecurityContext(expression="authentication") Authentication authentication){
        User user = userService.findOne(authentication.getName());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Transaction newTransaction =  new Transaction(user._id,timestamp);
        service.insert(newTransaction);
        return  newTransaction;
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('Admin')")
    public List<Transaction> findAll(){
        return service.findAll();
    }

}