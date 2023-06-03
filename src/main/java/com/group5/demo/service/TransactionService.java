package com.group5.demo.service;

import com.group5.demo.entity.Transaction;
import com.group5.demo.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionMapper mapper;

    public Integer insert (Transaction transaction){
        return mapper.insert(transaction);
    }

    public List<Transaction> findAll(){
        return mapper.findAllTransactions();
    }
}
