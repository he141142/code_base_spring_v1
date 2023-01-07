package com.sykros.codebase.service;

import com.sykros.codebase.domain.Book;
import com.sykros.codebase.repositories.BookRepository;
import com.sykros.codebase.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    BookRepository bookRepository;


    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book CreateBook(Book book) {
        return this.bookRepository.save(book);
    }
}
