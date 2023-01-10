package com.sykros.codebase.utils.module.validator.entity;

import com.sykros.codebase.repositories.BookRepository;

public class BookEntityValidation implements BookEntityValidate {
    BookRepository _bookRepository;
    public BookEntityValidation injectRepository(BookRepository bookRepository){
        this._bookRepository = bookRepository;
        return this;
    }

    @Override
    public boolean IsEntityExistById(Long id) {
        return false;
    }

    public BookEntityValidation(){

    }
}
