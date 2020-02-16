package com.training.app.ws.repository;

import com.training.app.ws.io.entity.AccountEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    AccountEntity findByUid(String Uid);
}