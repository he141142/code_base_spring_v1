package com.sykros.codebase.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "genres")
@Getter
@Setter
@NoArgsConstructor
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
