package com.sykros.codebase.service;

import com.sykros.codebase.domain.Book;
import com.sykros.codebase.dto.response.AddBookToInventoryResponse;
import com.sykros.codebase.enums.Exception.entity.EntityExceptionEnum;
import com.sykros.codebase.exception.entity.BookException;
import com.sykros.codebase.exception.entity.EntityException;
import com.sykros.codebase.repositories.BookRepository;
import com.sykros.codebase.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public AddBookToInventoryResponse AddBookToInventory(String inventoryCode, Long bookId) {
        return null;
    }

    public Optional<Book> findByID(Long id) throws EntityException {
        Optional<Book> book = this.bookRepository.findById(id);
        this.isEntityExist(book);
        return book;
    }

    public void isEntityExist(Optional<Book> entity) throws EntityException {
        if (entity.isEmpty()){
            throw new BookException.
                    builder().
                    WithException(EntityExceptionEnum.BOOK_NOT_FOUND_EXCEPTION).
                    build();
        }
    }
}
