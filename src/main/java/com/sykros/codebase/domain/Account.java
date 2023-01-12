package com.sykros.codebase.domain;

import com.sykros.codebase.utils.module.console.wagu.Board;
import com.sykros.codebase.utils.module.console.wagu.WaguTable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "accounts",indexes = {
        @Index(columnList = "user_name",name = "user_name_idx")
})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull()
    @NotEmpty
    @Pattern(regexp = "((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
    String password;

    @Column(name = "user_name",unique = true)
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

    @Override
    public String toString(){
        List<String> headersList = Arrays.asList("userName", "passwordHash", "role");
        Board board = new Board(75);
        List<List<String>> rowsList = Collections.singletonList(
                Arrays.asList(this.userName, this.passwordHash, this.getRole().getName())
        );
        return board.setInitialBlock(new WaguTable(board, 75, headersList, rowsList).tableToBlocks()).build().getPreview();
    }


}
