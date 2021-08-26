package com.revature.services;

import com.revature.model.Transaction;
import com.revature.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServices
{
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServices(TransactionRepository transactionRepository)
    {
        this.transactionRepository = transactionRepository;
    }

    public Transaction saveTransaction(Transaction transaction)
    {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransaction()
    {
        return transactionRepository.findAll();
    }

    
}
