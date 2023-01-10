package com.sykros.codebase.repositories;

import com.sykros.codebase.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    <S extends Book> S save(S entity);
    @Override
    <S extends Book> List<S> saveAll(Iterable<S> entities);
    @Override
    Optional<Book> findById(Long aLong);



}
