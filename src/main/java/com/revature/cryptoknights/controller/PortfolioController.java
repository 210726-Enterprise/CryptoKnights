package com.revature.cryptoknights.controller;

import com.revature.cryptoknights.dto.PortfolioDTO;
import com.revature.cryptoknights.model.Portfolio;
import com.revature.cryptoknights.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/portfolios")
@CrossOrigin
public class PortfolioController {

    private final PortfolioService service;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.service = portfolioService;
    }

    @GetMapping
    public @ResponseBody
    List<Portfolio> getAllPortfolios(){
        return service.getAllPortfolios();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Portfolio findPortfolioById(@PathVariable String id) {
        return service.getPortfolioById(Integer.parseInt(id));
    }

    @PostMapping
    public @ResponseBody
    Portfolio createPortfolio(@RequestBody PortfolioDTO portfolio)
    {
        Portfolio newPortfolio = portfolio.mapToPortfolio();
        return service.savePortfolio(newPortfolio);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
        service.deletePortfolio(Integer.parseInt(id));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody
    Portfolio updatePortfolio(@RequestBody PortfolioDTO portfolio)
    {
        Portfolio updatedPortfolio = portfolio.mapToPortfolio();
        return service.savePortfolio(updatedPortfolio);
    }
}
