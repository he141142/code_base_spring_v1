package com.sykros.codebase.utils.module.validator.entity;

import com.sykros.codebase.repositories.UserRepository;

public class AccountEntityValidation implements AccountValidate {
    UserRepository _repository;
    @Override
    public boolean IsEntityExistById(Long id) {

        return false;
    }


    public AccountEntityValidation injectRepository(UserRepository repository){
        this._repository = repository;
        return this;
    }

}
