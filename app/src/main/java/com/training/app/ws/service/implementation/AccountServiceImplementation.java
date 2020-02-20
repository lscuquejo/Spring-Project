package com.training.app.ws.service.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import com.training.app.ws.exceptions.AccountServiceExcepetion;
import com.training.app.ws.io.entity.AccountEntity;
import com.training.app.ws.repository.AccountRepository;
import com.training.app.ws.service.AccountService;
import com.training.app.ws.shared.Utils;
import com.training.app.ws.shared.dto.AccountDto;
import com.training.app.ws.ui.model.response.ErrorMessages;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    Utils utils;

    @Override
    public AccountDto createAccount(AccountDto account) {
        if (account.getName() != null) {
            AccountEntity storedAccountDetailsFromRequest = accountRepository.findByName(account.getName());

            if(storedAccountDetailsFromRequest != null) throw new AccountServiceExcepetion(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage());

            // checks if is a full name
            String[] splitedName = account.getName().split("\\s+");
            List<String> splitedNameAsList = Arrays.asList(splitedName);
            if (splitedNameAsList.size() > 1) {

                AccountEntity accountEntity = new AccountEntity();
                BeanUtils.copyProperties(account, accountEntity);

                Currency currency = Currency.getInstance("EUR");

                String publicUid = utils.generateUId(30);
                accountEntity.setUid(publicUid);
                accountEntity.setCurrency(currency);

                AccountEntity storedAccountDetails = accountRepository.save(accountEntity);

                AccountDto returnValue = new AccountDto();
                BeanUtils.copyProperties(storedAccountDetails, returnValue);

                return returnValue;
            } throw new AccountServiceExcepetion(ErrorMessages.BAD_REQUEST.getErrorMessage() + "name field : It must be a full name");
        } throw new AccountServiceExcepetion(ErrorMessages.BAD_REQUEST.getErrorMessage() + "name field : It must be a full name");
    }

    @Override
    public AccountDto getAccountByUId(String uId) {
        AccountDto returnValue = new AccountDto();
        AccountEntity accountEntity = accountRepository.findByUid(uId);

        if(accountEntity == null)
            throw new AccountServiceExcepetion(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        BeanUtils.copyProperties(accountEntity, returnValue);

        return returnValue;
    }

    @Override
    public AccountDto updateAccount(String uId, AccountDto account) {
        AccountDto returnValue = new AccountDto();
        AccountEntity accountEntity = accountRepository.findByUid(uId);

        if(accountEntity == null)
            throw new AccountServiceExcepetion(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        accountEntity.setBalance(account.getBalance());
        accountEntity.setName(account.getName());
        accountEntity.setTreasury(account.getTreasury());

        AccountEntity updatedAccountDetails = accountRepository.save(accountEntity);

        BeanUtils.copyProperties(updatedAccountDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteAccount(String uId) {
        AccountEntity accountEntity = accountRepository.findByUid(uId);
        
        if(accountEntity == null)
            throw new AccountServiceExcepetion(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        accountRepository.delete(accountEntity);
    }

    @Override
    public List<AccountDto> getAccounts(int page, int limit) {
        List<AccountDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit);
        
        Page<AccountEntity> accountsPage = accountRepository.findAll(pageableRequest);
        List<AccountEntity> accounts = accountsPage.getContent();

        for (AccountEntity accountEntity : accounts) {
            AccountDto accountDto = new AccountDto();
            BeanUtils.copyProperties(accountEntity, accountDto);
            returnValue.add(accountDto);
        }

        return returnValue;
    }
}