package com.revature.cryptoknights.dto;

import com.revature.cryptoknights.model.Portfolio;
import com.revature.cryptoknights.model.Transaction;
import com.revature.cryptoknights.model.User;
import com.revature.cryptoknights.service.TransactionServices;
import com.revature.cryptoknights.service.UserService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PortfolioDTO
{
    private int portfolioId;

    private String porfolio_name;

    private double bitcoin;

    private double ethereum;

    private double dogecoin;

    private double usd;

    private int[] transactions = new int[0];

    private int[] users = new int[0];

    @Autowired
    private TransactionServices transactionServices;

    @Autowired
    private UserService userService;

    public Portfolio mapToPortfolio()
    {
        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioId(portfolioId);
        portfolio.setBitcoin(bitcoin);
        portfolio.setDogecoin(dogecoin);
        portfolio.setEthereum(ethereum);
        portfolio.setPorfolio_name(porfolio_name);
        portfolio.setUsd(usd);
        portfolio.setTransactions(findTransactions());
        portfolio.setUsers(findUsers());

        return portfolio;
    }

    private List<Transaction> findTransactions()
    {
        List<Transaction> transactionsList = new ArrayList<>();
        for(int i = 0; i < transactions.length; i++)
        {
            transactionsList.add(transactionServices.getTransactionById(i));
        }
        return transactionsList;
    }

    private List<User> findUsers()
    {
        List<User> userList = new ArrayList<>();
        System.out.println(userService);
        for(int i = 0; i < users.length; i++)
        {
            userList.add(userService.getUserByUserId(i));
        }
        return userList;
    }
}
