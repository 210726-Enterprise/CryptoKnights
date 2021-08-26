package com.revature.controller;

import com.revature.model.Transaction;
import com.revature.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TransactionController
{
    TransactionServices transactionServices;

    @Autowired
    public TransactionController(TransactionServices transactionServices)
    {
        this.transactionServices = transactionServices;
    }

    public List<Transaction> getAllTransactions()
    {
        return transactionServices.getAllTransactions();
    }

    public Transaction createTransaction(Transaction transaction)
    {
        return transactionServices.saveTransaction(transaction);
    }
}
