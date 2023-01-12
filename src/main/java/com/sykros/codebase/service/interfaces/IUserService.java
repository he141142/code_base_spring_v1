package com.sykros.codebase.service.interfaces;

import com.sykros.codebase.domain.Account;
import com.sykros.codebase.exception.entity.EntityException;

import java.util.Optional;

public interface IUserService {
    Optional<Account> GetUserByUserName(String userName) throws EntityException;
}
