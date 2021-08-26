package com.revature.project2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="portfolios")
@Getter
@Setter
@NoArgsConstructor
public class Portfolio {

    @Id
    @Column(name="portfolio_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int portfolioId;

    @Column(name="portfolio_name")
    private String porfolio_name;

    @Column(name="bitcoin")
    private double bitcoin;

    @Column(name="ethereum")
    private double ethereum;

    @Column(name="dogecoin")
    private double dogecoin;

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
