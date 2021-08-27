package com.revature.cryptoknights.service;

import com.revature.cryptoknights.model.Transaction;
import com.revature.cryptoknights.repo.TransactionRepository;
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

    public List<Transaction> getAllTransactions()
    {
        return transactionRepository.findAll();
    }


}
