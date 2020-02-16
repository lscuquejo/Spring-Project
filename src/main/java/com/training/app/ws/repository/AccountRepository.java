package com.training.app.ws.repository;

import com.training.app.ws.io.entity.AccountEntity;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<AccountEntity, Long> {
    AccountEntity findByUid(String Uid);
}