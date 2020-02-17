package com.training.app.ws.ui.model.response;

import java.math.BigDecimal;
import java.util.Currency;

public class AccountRest {
    private String uid;
    private String name;
    private Currency currency;
    private BigDecimal balance;
    private Boolean treasury;

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Boolean getTreasury() {
        return treasury;
    }

    public void setTreasury(Boolean breasury) {
        this.treasury = breasury;
    }

}