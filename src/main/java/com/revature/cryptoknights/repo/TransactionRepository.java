package com.revature.cryptoknights.repo;

import com.revature.cryptoknights.model.Portfolio;
import com.revature.cryptoknights.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>
{
    List<Transaction> findAllByPortfolioOrderByTransactionDateTimeDesc(Portfolio portfolio);
}
