package com.sykros.codebase.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sykros.codebase.enums.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @NotNull
    @JsonProperty("description")
    private String description;

    @NotEmpty
    @NotNull
    @JsonProperty("name")
    private String name;


    public Role(RoleEnum roleEnum){
        this.description = roleEnum.Description();
        this.name = roleEnum.Name();
    }

}
