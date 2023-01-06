package com.sykros.codebase.repositories;

import com.sykros.codebase.domain.Account;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<Account, Long> {
    Optional<Account> findAccountByUserName(String username);
    Optional<Account> findFirstByUserName(String username);
    Boolean existsByUserName(String username);

    void deleteAllByUserName(@NotNull @NotEmpty String userName);
}
