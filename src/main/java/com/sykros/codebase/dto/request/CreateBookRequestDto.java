package com.sykros.codebase.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequestDto {
    @NotEmpty
    @JsonProperty("description")
    private String description;

    @NotEmpty
    @JsonProperty("book_name")
    private String bookName;

    @NotNull
    @JsonProperty("pages")
    private int pages;
}
