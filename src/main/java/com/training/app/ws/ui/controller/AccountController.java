package com.training.app.ws.ui.controller;

import com.training.app.ws.exceptions.AccountServiceExcepetion;
import com.training.app.ws.service.AccountService;
import com.training.app.ws.shared.dto.AccountDto;
import com.training.app.ws.ui.model.request.AccountDetailsRequestModel;
import com.training.app.ws.ui.model.response.AccountRest;
import com.training.app.ws.ui.model.response.ErrorMessages;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts") // http://provided:port/
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(
        path = "/{uid}",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
        )
    public AccountRest getAccount(@PathVariable String uid)
    {
        AccountRest returnValue = new AccountRest();

        AccountDto accountDto = accountService.getAccountByUId(uid);
        BeanUtils.copyProperties(accountDto, returnValue);

        return returnValue;
    }

    @PostMapping(
        consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
        )
    public AccountRest createAccount(@RequestBody AccountDetailsRequestModel accountDetails) throws Exception
    {
        AccountRest returnValue = new AccountRest();

        if(accountDetails.getName().isEmpty()) throw new AccountServiceExcepetion(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        AccountDto AccountDto = new AccountDto();
        BeanUtils.copyProperties(accountDetails, AccountDto);

        AccountDto createdAccount = accountService.createAccount(AccountDto);
        BeanUtils.copyProperties(createdAccount, returnValue);

        return returnValue;
    }

    @PutMapping(
        path = "/{uid}",
        consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public AccountRest UpdateAccount(
        @RequestBody AccountDetailsRequestModel accountDetails, 
        @PathVariable String uid
        )
    {
        AccountRest returnValue = new AccountRest();

        if(accountDetails.getName().isEmpty()) throw new AccountServiceExcepetion(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        AccountDto AccountDto = new AccountDto();
        BeanUtils.copyProperties(accountDetails, AccountDto);

        AccountDto updatedAccount = accountService.updateAccount(AccountDto);
        BeanUtils.copyProperties(updatedAccount, returnValue);

        return returnValue;
    }

    @DeleteMapping
    public String DeleteAccount()
    {
        return "delete Account has been called";
    }

}