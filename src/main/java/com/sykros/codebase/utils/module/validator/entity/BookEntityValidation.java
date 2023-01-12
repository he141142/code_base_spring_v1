package com.sykros.codebase.utils.module.validator.entity;

import com.sykros.codebase.domain.Book;
import com.sykros.codebase.exception.entity.BookException;
import com.sykros.codebase.exception.entity.EntityException;
import com.sykros.codebase.repositories.BookRepository;
import com.sykros.codebase.service.interfaces.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class BookEntityValidation implements BookEntityValidate {
    Logger logger = LoggerFactory.getLogger(BookEntityValidation.class);


    BookRepository _bookRepository;

    IBookService bookService;

    public BookEntityValidation injectRepository(BookRepository bookRepository){
        this._bookRepository = bookRepository;
        return this;
    }

    public BookEntityValidation injectBookService(IBookService bookService){
        this.bookService = bookService;
        return this;
    }

    @Override
    public boolean IsEntityExistById(Long id) {
       try{
           Optional<Book> book = this.bookService.findByID(id);
           logger.info(book.orElse(new Book()).toString());
       }catch (EntityException exception){
           System.out.println(exception.getMessage());;
           return false;
       }
       return true;
    }

}
