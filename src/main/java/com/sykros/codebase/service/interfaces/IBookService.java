package com.sykros.codebase.service.interfaces;

import com.sykros.codebase.domain.Book;
import com.sykros.codebase.dto.response.AddBookToInventoryResponse;
import com.sykros.codebase.exception.entity.EntityException;

import java.util.Optional;

public interface IBookService {
    Book CreateBook(Book book) ;
    AddBookToInventoryResponse AddBookToInventory(String inventoryCode, Long bookId);
    Optional<Book> findByID(Long id) throws EntityException;
}
