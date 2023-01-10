package com.sykros.codebase.repositories;

import com.sykros.codebase.domain.Book;
import com.sykros.codebase.domain.BookInventory;
import com.sykros.codebase.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<BookInventory, Long> {
    Book AddBook(Book book);
    List<Book> ListAllBook();
}
