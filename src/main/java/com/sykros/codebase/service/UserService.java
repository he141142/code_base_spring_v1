package com.sykros.codebase.service;

import com.sykros.codebase.domain.Account;
import com.sykros.codebase.enums.Exception.entity.UserExceptionEnum;
import com.sykros.codebase.exception.entity.EntityException;
import com.sykros.codebase.exception.entity.UserException;
import com.sykros.codebase.repositories.UserRepository;
import com.sykros.codebase.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserRepository userRepository;

    public Optional<Account> GetUserByUserName(String userName) throws EntityException {
        Optional<Account> account = this.userRepository.findAccountByUserName(userName);
        this.CheckUserExist(account);
        return account;
    }

    public void CheckUserExist(Optional<Account> account) throws EntityException {
        if(account.isEmpty()){
            throw new UserException.
                    builder().
                    WithException(UserExceptionEnum.USER_NOT_FOUND).
                    build();
        }
    }
}
