package com.training.app.ws.service;

import java.util.List;

import com.training.app.ws.shared.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto account);
    AccountDto getAccountByUId(String uId);
    AccountDto updateAccount(String uId, AccountDto account);
    void deleteAccount(String uId);
    List <AccountDto> getAccounts(int page, int limit);
}