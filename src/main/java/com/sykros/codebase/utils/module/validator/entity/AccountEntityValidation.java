package com.sykros.codebase.utils.module.validator.entity;

import com.sykros.codebase.domain.Account;
import com.sykros.codebase.exception.entity.EntityException;
import com.sykros.codebase.repositories.UserRepository;
import com.sykros.codebase.service.UserService;
import com.sykros.codebase.service.interfaces.IUserService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class AccountEntityValidation implements AccountValidate {

    Logger logger = LoggerFactory.getLogger(AccountEntityValidation.class);

    UserRepository _repository;
    IUserService userService;

    @Override
    public boolean IsEntityExistById(Long id) {

        return false;
    }

    public AccountEntityValidation injectRepository(UserRepository repository) {
        this._repository = repository;
        return this;
    }

    public AccountEntityValidation injectUserService(IUserService userService) {
        this.userService = userService;
        return this;
    }

    public boolean IsAccountExist(String userName) {
        try {
            Optional<Account> account = this.userService.GetUserByUserName(userName);
        } catch (EntityException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
