package com.revature.cryptoknights.service;

import com.revature.cryptoknights.model.Portfolio;
import com.revature.cryptoknights.repo.PortfolioRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PortfolioServiceTest
{
    @Autowired
    private PortfolioService portfolioServiceTest;

    @MockBean
    private PortfolioRepository mockPortfolioRepository;

    private Portfolio portfolio;

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void savePortfolio()
    {
        when(mockPortfolioRepository.save(portfolio)).thenReturn(portfolio);
        assertEquals(portfolioServiceTest.savePortfolio(portfolio), portfolio);
    }

    @Test
    void getPortfolioById()
    {
    }

    @Test
    void getAllPortfolios()
    {
    }

    @Test
    void deletePortfolio()
    {
        when(mockPortfolioRepository.delete(portfolio)).thenReturn(portfolio);
        assertEquals(portfolioServiceTest.savePortfolio(portfolio), portfolio);
    }
}