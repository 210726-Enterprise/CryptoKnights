package com.revature.cryptoknights.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "transactionId"
)
public class Transaction
{
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @Column(name = "transaction_datetime")
    private LocalDateTime transactionDateTime = LocalDateTime.now();

    @Column(name = "transaction_in_currency")
    private String transactionInCurrency;

    @Column(name = "transaction_in_amount")
    private double transactionInAmount;

    @Column(name = "transaction_out_currency")
    private String transactionOutCurrency;

    @Column(name = "transaction_out_amount")
    private double transactionOutAmount;
}
