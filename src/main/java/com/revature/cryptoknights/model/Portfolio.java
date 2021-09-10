package com.revature.cryptoknights.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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
    @JsonIdentityReference(alwaysAsId = true)
    private List<Transaction> transactions;

    @ManyToMany
    @JoinTable(
            name="users_portfolios",
            joinColumns=@JoinColumn(name="portfolio_id", referencedColumnName = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    )
    @JsonIdentityReference(alwaysAsId = true)
    private List<User> users;

    @JsonSetter("users")
    public void setUsers(int[] userIds)
    {
        List<User> newUsers  = new ArrayList<>();
        for(int i = 0; i < userIds.length; i++)
        {
            User user = new User();
            user.setUserId(userIds[i]);
            newUsers.add(user);
        }
        this.users = newUsers;
    }

    @JsonSetter("transactions")
    public void setTransactions(int[] transactionIds)
    {
        List<Transaction> newTransactions  = new ArrayList<>();
        for(int i = 0; i < transactionIds.length; i++)
        {
            Transaction transaction = new Transaction();
            transaction.setTransactionId(transactionIds[i]);
            newTransactions.add(transaction);
        }
        this.transactions = newTransactions;
    }
}
