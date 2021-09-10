package com.revature.cryptoknights.controller;

import com.revature.cryptoknights.dto.TransactionDTO;
import com.revature.cryptoknights.model.Portfolio;
import com.revature.cryptoknights.model.Transaction;
import com.revature.cryptoknights.service.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/transactions")
@Controller
@CrossOrigin
public class TransactionController
{
    TransactionServices transactionServices;

    @Autowired
    public TransactionController(TransactionServices transactionServices)
    {
        this.transactionServices = transactionServices;
    }

    @GetMapping
    public @ResponseBody
    List<Transaction> getAllTransactions()
    {
        return transactionServices.getAllTransactions();
    }

    @GetMapping("/{portfolio}")
    public @ResponseBody
    List<Transaction> getAllTransactionsByPortfolio(@PathVariable Portfolio portfolio)
    {
        return transactionServices.getAllByPortfolio(portfolio);
    }

    @PostMapping
    public @ResponseBody
    Transaction createTransaction(@RequestBody TransactionDTO transaction)
    {
        Transaction newTransaction = transaction.mapToTransaction();
        return transactionServices.saveTransaction(newTransaction);
    }
}
