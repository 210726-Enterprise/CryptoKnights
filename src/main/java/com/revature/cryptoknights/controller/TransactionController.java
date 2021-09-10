package com.revature.cryptoknights.controller;

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

//    @GetMapping
//    public @ResponseBody
//    List<Transaction> getAllTransactions()
//    {
//        return transactionServices.getAllTransactions();
//    }

    @GetMapping
    public @ResponseBody
    List<Transaction> getAllTransactionsByPortfolio(@RequestParam Portfolio portfolio)
    {
        return transactionServices.getAllByPortfolio(portfolio);
    }

    @PostMapping
    public @ResponseBody
    Transaction createTransaction(@RequestBody Transaction transaction)
    {
        return transactionServices.saveTransaction(transaction);
    }
}
