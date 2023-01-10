package com.sykros.codebase.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "change-role-history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleChangeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "account_id")
    Long accountId;

    @Column(name = "role_id")
    Long roleId;

}
