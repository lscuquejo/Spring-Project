package com.training.app.ws.io.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "accounts")
public class AccountEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String uid;

    @Column(nullable = false, length = 150, unique = true)
    private String name;

    @Column(nullable = false)
    private Currency Currency;

    @Column(nullable = false)
    private BigDecimal Balance;

    @Column(nullable = true)
    private Boolean Treasury;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return Currency;
    }

    public void setCurrency(Currency currency) {
        Currency = currency;
    }

    public BigDecimal getBalance() {
        return Balance;
    }

    public void setBalance(BigDecimal balance) {
        Balance = balance;
    }

    public Boolean getTreasury() {
        return Treasury;
    }

    public void setTreasury(Boolean treasury) {
        Treasury = treasury;
    }
}