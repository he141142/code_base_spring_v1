package com.sykros.codebase.repositories;

import com.sykros.codebase.domain.Book;
import com.sykros.codebase.domain.Role;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {

    <S extends Role> Optional<S> findOneByName(String roleName);
}
