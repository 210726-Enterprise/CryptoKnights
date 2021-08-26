package com.revature.project2.controller;

import com.revature.project2.model.Portfolio;
import com.revature.project2.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/portfolios")
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
    Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return service.savePortfolio(portfolio);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
        service.deletePortfolio(Integer.parseInt(id));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody
    Portfolio updatePortfolio(@RequestBody Portfolio portfolio) {
        return service.savePortfolio(portfolio);
    }
}
