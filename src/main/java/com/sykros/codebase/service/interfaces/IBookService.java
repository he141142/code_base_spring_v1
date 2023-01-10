package com.sykros.codebase.service.interfaces;

import com.sykros.codebase.domain.Book;
import com.sykros.codebase.dto.response.AddBookToInventoryResponse;

public interface IBookService {
    Book CreateBook(Book book) ;
    AddBookToInventoryResponse AddBookToInventory(String inventoryCode, Long bookId);
}
