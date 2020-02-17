package com.training.app.ws.ui.model.request;

import java.math.BigDecimal;
import java.util.Currency;

public class AccountDetailsRequestModel {
    private String name;
    private Currency Currency;
    private BigDecimal Balance;
    private Boolean Treasury;

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