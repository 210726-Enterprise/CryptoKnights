package com.revature.cryptoknights.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userId"
)
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name="username", unique = true, nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email", unique = true)
    private String email;

    @ManyToMany(mappedBy = "users")
    @JsonIdentityReference(alwaysAsId = true)
    List<Portfolio> portfolios;

    @JsonSetter("portfolios")
    public void setPortfolios(int[] portfolioIds)
    {
        List<Portfolio> newPortfolios  = new ArrayList<>();
        for(int i = 0; i < portfolioIds.length; i++)
        {
            Portfolio portfolio = new Portfolio();
            portfolio.setPortfolioId(portfolioIds[i]);
            newPortfolios.add(portfolio);
        }
        this.portfolios = newPortfolios;
    }
}
