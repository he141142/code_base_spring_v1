package com.sykros.codebase.config.security.service;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sykros.codebase.config.security.jwt.JwtResponse;
import com.sykros.codebase.domain.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
public class UserDetail implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String passwordHash;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }


    public UserDetail(Long id, String username, String password,
                      Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUserPasswordHash() {
        return this.passwordHash;
    }
    public UserDetail setUserPasswordHash(String _hash){
        this.passwordHash = _hash;
        return this;
    }

    public static UserDetail buildUser(Account account){
//        List<GrantedAuthority> authorities = account.getUserRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRole().getName()))
//                .collect(Collectors.toList());

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(""));
        return new UserDetail(
                account.getId(),
                account.getUserName(),
                account.getPassword(),
                authorities).setUserPasswordHash(account.getPasswordHash());
    }

    @Override
    public String getPassword() {
        return this.passwordHash;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setJWTHashed(){

    }

    public JwtResponse buildJWTResponse(String jwt_hash){
        return new JwtResponse.JwtResponseBuilder()
                .setJwtHash(jwt_hash)
                .setPasswordHash(this.getUserPasswordHash()).
                        build(this.getUsername());
    }
}
