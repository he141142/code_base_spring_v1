package com.sykros.codebase.config.security.service;

import com.sykros.codebase.domain.Account;
import com.sykros.codebase.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailServiceImpl  implements UserDetailsService {
    UserRepository userRepository;

    public UserDetailServiceImpl(@Autowired UserRepository _userRepository) {
        this.userRepository = _userRepository;
    }

    @Override
    @Transactional
    public UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = this.userRepository.findAccountByUserName(username);
        return account.map(UserDetail::buildUser).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    }
}
