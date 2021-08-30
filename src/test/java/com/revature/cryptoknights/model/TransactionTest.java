package com.revature.cryptoknights.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.sound.sampled.Port;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest
{
    @Autowired
    private Transaction testTransaction;

    @MockBean
    private LocalDateTime mockLocalDateTime1;

    @MockBean
    private LocalDateTime mockLocalDateTime2;

    private Portfolio mockPortfolio1;

    @BeforeEach
    void setUp()
    {
        mockPortfolio1 = new Portfolio();

        testTransaction.setTransactionId(1);
        testTransaction.setTransactionDateTime(mockLocalDateTime1);
        testTransaction.setTransactionInCurrency("testCurrencyIn");
        testTransaction.setTransactionInAmount(100);
        testTransaction.setTransactionOutCurrency("testCurrencyOut");
        testTransaction.setTransactionOutAmount(200);
        testTransaction.setPortfolio(mockPortfolio1);
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void getTransactionId()
    {
        assertEquals(testTransaction.getTransactionId(), 1);
    }

    @Test
    void getPortfolio()
    {
        assertEquals(testTransaction.getPortfolio(), mockPortfolio1);
    }

    @Test
    void getTransactionDateTime()
    {
        assertEquals(testTransaction.getTransactionDateTime(), mockLocalDateTime1);
    }

    @Test
    void getTransactionInCurrency()
    {
        assertEquals(testTransaction.getTransactionInCurrency(), "testCurrencyIn");
    }

    @Test
    void getTransactionInAmount()
    {
        assertEquals(testTransaction.getTransactionInAmount(), 100);
    }

    @Test
    void getTransactionOutCurrency()
    {
        assertEquals(testTransaction.getTransactionOutCurrency(), "testCurrencyOut");
    }

    @Test
    void getTransactionOutAmount()
    {
        assertEquals(testTransaction.getTransactionOutAmount(), 200);
    }

    @Test
    void setTransactionId()
    {
        testTransaction.setTransactionId(2);
        assertEquals(testTransaction.getTransactionId(), 2);
    }

    @Test
    void setPortfolio()
    {
        Portfolio mockPortfolio2 = new Portfolio();
        testTransaction.setPortfolio(mockPortfolio2);
        assertEquals(testTransaction.getPortfolio(), mockPortfolio2);
    }

    @Test
    void setTransactionDateTime()
    {
        testTransaction.setTransactionDateTime(mockLocalDateTime2);
        assertEquals(testTransaction.getTransactionDateTime(), mockLocalDateTime2);
    }

    @Test
    void setTransactionInCurrency()
    {
        testTransaction.setTransactionInCurrency("testCurrencyIn2");
        assertEquals(testTransaction.getTransactionInCurrency(), "testCurrencyIn2");
    }

    @Test
    void setTransactionInAmount()
    {
        testTransaction.setTransactionInAmount(1000);
        assertEquals(testTransaction.getTransactionInAmount(), 1000);
    }

    @Test
    void setTransactionOutCurrency()
    {
        testTransaction.setTransactionOutCurrency("testCurrencyOut2");
        assertEquals(testTransaction.getTransactionOutCurrency(), "testCurrencyOut2");
    }

    @Test
    void setTransactionOutAmount()
    {
        testTransaction.setTransactionOutAmount(20);
        assertEquals(testTransaction.getTransactionOutAmount(), 20);
    }
}