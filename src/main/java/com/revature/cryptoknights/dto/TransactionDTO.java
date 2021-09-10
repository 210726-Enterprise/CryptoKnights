package com.revature.cryptoknights.dto;

import com.revature.cryptoknights.model.Portfolio;
import com.revature.cryptoknights.model.Transaction;
import com.revature.cryptoknights.service.PortfolioService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDTO
{
    private int transactionId;

    private int portfolio = 0;

    private String transactionInCurrency;

    private double transactionInAmount;

    private String transactionOutCurrency;

    private double transactionOutAmount;

    @Autowired(required = true)
    private PortfolioService portfolioService;

    public Transaction mapToTransaction()
    {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(transactionId);
        transaction.setTransactionOutAmount(transactionOutAmount);
        transaction.setTransactionInAmount(transactionInAmount);
        transaction.setTransactionInCurrency(transactionInCurrency);
        transaction.setTransactionOutCurrency(transactionOutCurrency);
        transaction.setPortfolio(findPortfolio());

        return transaction;
    }

    private Portfolio findPortfolio()
    {
        return portfolioService.getPortfolioById(portfolio);
    }
}
