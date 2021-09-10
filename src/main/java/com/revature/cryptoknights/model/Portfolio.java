package com.revature.cryptoknights.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="portfolios")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "portfolioId"
)
public class Portfolio {

    @Id
    @Column(name="portfolio_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int portfolioId;

    @Column(name="portfolio_name")
    private String porfolio_name;

    @Column(name="bitcoin", nullable = false)
    private double bitcoin;

    @Column(name="ethereum", nullable = false)
    private double ethereum;

    @Column(name="dogecoin", nullable = false)
    private double dogecoin;

    @Column(name="usd", nullable = false)
    private double usd;

    @OneToMany(mappedBy = "portfolio")
    private List<Transaction> transactions;

    @ManyToMany
    @JoinTable(
            name="users_portfolios",
            joinColumns=@JoinColumn(name="portfolio_id", referencedColumnName = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    )
    private List<User> users;
}
