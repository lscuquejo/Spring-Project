package com.training.app.ws.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

public class AccountDto implements Serializable{
    private static final long serialVersionUID = -7919644919532035848L;

    private long id;
    private String uid;
    private String name;
    private Currency Currency;
    private BigDecimal Balance;
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