package com.revature.cryptoknights.service;

import com.revature.cryptoknights.repo.PortfolioRepository;
import com.revature.cryptoknights.model.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public Portfolio savePortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public Portfolio getPortfolioById(int id) {
        return portfolioRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    public void deletePortfolio(int id) {
        portfolioRepository.findById(id).ifPresent(portfolioRepository::delete);
    }

}
