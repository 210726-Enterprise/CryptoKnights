package com.revature.cryptoknights.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.cryptoknights.model.Portfolio;
import com.revature.cryptoknights.model.Transaction;
import com.revature.cryptoknights.service.TransactionServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionControllerTest
{
    @Autowired
    private TransactionController transactionControllerTest;

    private MockMvc mockMvc;

    @MockBean
    private TransactionServices mockTransactionServices;

    private LocalDateTime mockLocalDateTime;
    
    List<Transaction> transactionList;
    Transaction transaction;

    @BeforeEach
    void setUp()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(transactionControllerTest).build();
        Portfolio mockPortfolio = new Portfolio();
        mockPortfolio.setPortfolioId(1);
        mockLocalDateTime = LocalDateTime.now();

        transaction = new Transaction();
        transaction.setTransactionId(1);
        transaction.setTransactionDateTime(mockLocalDateTime);
        transaction.setTransactionInCurrency("testCurrencyIn");
        transaction.setTransactionInAmount(100);
        transaction.setTransactionOutCurrency("testCurrencyOut");
        transaction.setTransactionOutAmount(200);
        transaction.setPortfolio(mockPortfolio);

        transactionList = new ArrayList<>();
        transactionList.add(transaction);
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void getAllTransactions() throws Exception
    {
        when(mockTransactionServices.getAllTransactions()).thenReturn(transactionList);

        mockMvc.perform(get("/transaction"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].transactionId").value(1))
                .andExpect(jsonPath("$[0].portfolio").value(1))
                .andExpect(jsonPath("$[0].transactionDateTime").value(LocalDateTime.now().toString()))
                .andExpect(jsonPath("$[0].transactionInCurrency").value("testCurrencyIn"))
                .andExpect(jsonPath("$[0].transactionInAmount").value(100))
                .andExpect(jsonPath("$[0].transactionOutCurrency").value("testCurrencyOut"))
                .andExpect(jsonPath("$[0].transactionOutAmount").value(200))
                .andReturn();
    }

    @Test
    void createTransaction() throws Exception
    {
        when(mockTransactionServices.saveTransaction(transaction)).thenReturn(transaction);

        mockMvc.perform(put("/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(transaction)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.transactionId").value(1))
                .andExpect(jsonPath("$.portfolio").value(1))
                .andExpect(jsonPath("$.transactionDateTime").value(LocalDateTime.now().toString()))
                .andExpect(jsonPath("$.transactionInCurrency").value("testCurrencyIn"))
                .andExpect(jsonPath("$.transactionInAmount").value(100))
                .andExpect(jsonPath("$.transactionOutCurrency").value("testCurrencyOut"))
                .andExpect(jsonPath("$.transactionOutAmount").value(200))
                .andReturn();
    }
}