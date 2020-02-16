package com.training.app.ws.service;

import com.training.app.ws.shared.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto account);
    AccountDto getAccountByUId(String uId);
    AccountDto updateAccount(String uId, AccountDto account);
}