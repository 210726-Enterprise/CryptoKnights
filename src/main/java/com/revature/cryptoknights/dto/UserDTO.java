package com.revature.cryptoknights.dto;

import com.revature.cryptoknights.model.Portfolio;
import com.revature.cryptoknights.model.User;
import com.revature.cryptoknights.service.PortfolioService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO
{
    private int userId;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private int[] portfolios = new int[0];

    @Autowired(required = true)
    private PortfolioService portfolioService;

    public User mapToUser()
    {
        User user = new User();
        user.setUserId(userId);
        user.setEmail(email);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setPassword(password);
        user.setLastName(lastName);
        user.setPortfolios(findPortfolios());

        return user;
    }

    private List<Portfolio> findPortfolios()
    {
        List<Portfolio> portfolioList = new ArrayList<>();
        for(int i = 0; i < portfolios.length; i++)
        {
            portfolioList.add(portfolioService.getPortfolioById(i));
        }
        return portfolioList;
    }
}
