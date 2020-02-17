package com.training.app.ws.service.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import com.training.app.ws.io.entity.AccountEntity;
import com.training.app.ws.repository.AccountRepository;
import com.training.app.ws.shared.dto.AccountDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AccountServiceImplementationTest {
    
    @InjectMocks
    AccountServiceImplementation accountService;

    @Mock
    AccountRepository accountRepository;

    @BeforeEach
    void setUp()throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void testGetAccount() {

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setId(1L);
        accountEntity.setBalance(BigDecimal.valueOf(2000));
        accountEntity.setUid("123123");
        accountEntity.setName("mocked");
        accountEntity.setTreasury(false);

        when(accountRepository.findByUid(anyString())).thenReturn(accountEntity);
        
        AccountDto accountDto = accountService.getAccountByUId("123123");

        assertNotNull(accountDto, "accountDTO is null");
        assertEquals("mocked", accountDto.getName());
    }
}