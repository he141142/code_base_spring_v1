package com.sykros.codebase.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull()
    @NotEmpty
    @Pattern(regexp = "((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
    String password;

    @Column(name = "user_name")
    @NotNull
    @NotEmpty
    String userName;

     @NotNull @NotEmpty String status;

    @Column(name = "password_hash")
    String passwordHash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    Role role;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    List<ShoppingSession> shoppingSessions ;

    public Account AddShoppingSession(ShoppingSession shoppingSession)  {
        if (this.shoppingSessions == null) this.shoppingSessions = new ArrayList<>();
        this.shoppingSessions.add(shoppingSession);
        return this;
    }


}
