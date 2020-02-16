package com.training.app.ws.ui.controller;

import java.util.ArrayList;
import java.util.List;

import com.training.app.ws.exceptions.AccountServiceExcepetion;
import com.training.app.ws.service.AccountService;
import com.training.app.ws.shared.dto.AccountDto;
import com.training.app.ws.ui.model.request.AccountDetailsRequestModel;
import com.training.app.ws.ui.model.response.AccountRest;
import com.training.app.ws.ui.model.response.ErrorMessages;
import com.training.app.ws.ui.model.response.OperationStatusModel;
import com.training.app.ws.ui.model.response.RequestOperationName;
import com.training.app.ws.ui.model.response.RequestOperationStatus;

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
import org.springframework.web.bind.annotation.RequestParam;
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

        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(accountDetails, accountDto);

        AccountDto createdAccount = accountService.createAccount(accountDto);
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

        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(accountDetails, accountDto);

        AccountDto updatedAccount = accountService.updateAccount(uid, accountDto);
        BeanUtils.copyProperties(updatedAccount, returnValue);

        return returnValue;
    }

    @DeleteMapping(
        path = "/{uid}",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public OperationStatusModel DeleteAccount(@PathVariable String uid)
    {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());

        accountService.deleteAccount(uid);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        return returnValue;
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List <AccountRest> getAccounts(
        @RequestParam(value = "page", defaultValue = "1")int page,
        @RequestParam(value= "limit", defaultValue = "5")int limit
        )
    {
        List<AccountRest> returnValue = new ArrayList<>();

        List<AccountDto> accounts = accountService.getAccounts(page, limit);

        for (AccountDto accountDto : accounts) {
            AccountRest accountModel = new AccountRest();
            BeanUtils.copyProperties(accountDto, accountModel);
            returnValue.add(accountModel);
        }

        return returnValue;
    }
}