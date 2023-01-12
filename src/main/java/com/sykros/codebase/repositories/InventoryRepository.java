package com.sykros.codebase.repositories;

import com.sykros.codebase.domain.Book;
import com.sykros.codebase.domain.BookInventory;
import com.sykros.codebase.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<BookInventory, Long> {
}
