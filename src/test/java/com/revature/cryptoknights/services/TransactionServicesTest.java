package com.revature.cryptoknights.services;

import com.revature.cryptoknights.model.Portfolio;
import com.revature.cryptoknights.model.Transaction;
import com.revature.cryptoknights.repo.TransactionRepository;
import com.revature.cryptoknights.service.TransactionServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionServicesTest
{
    @Autowired
    private TransactionServices transactionServicesTest;

    @MockBean
    private TransactionRepository mockTransactionRepository;

    private LocalDateTime mockLocalDateTime;

    private List<Transaction> transactionList;
    private Transaction transaction;

    @BeforeEach
    void setUp()
    {
        mockLocalDateTime = LocalDateTime.now();

        transaction = new Transaction();
        transaction.setTransactionId(1);
        transaction.setTransactionDateTime(mockLocalDateTime);
        transaction.setTransactionInCurrency("testCurrencyIn");
        transaction.setTransactionInAmount(100);
        transaction.setTransactionOutCurrency("testCurrencyOut");
        transaction.setTransactionOutAmount(200);
        transaction.setPortfolio(new Portfolio());

        transactionList = new ArrayList<>();
        transactionList.add(transaction);
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void saveTransaction()
    {
        when(mockTransactionRepository.save(transaction)).thenReturn(transaction);
        assertEquals(transactionServicesTest.saveTransaction(transaction), transaction);
    }

    @Test
    void getAllTransactions()
    {
        when(mockTransactionRepository.findAll()).thenReturn(transactionList);
        assertEquals(transactionServicesTest.getAllTransactions(), transactionList);
    }
}