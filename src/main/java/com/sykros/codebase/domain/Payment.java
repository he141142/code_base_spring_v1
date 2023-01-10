package com.sykros.codebase.domain;

import com.sykros.codebase.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "amount",nullable = false)
    @NotNull
    int amount = 0;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;




}
