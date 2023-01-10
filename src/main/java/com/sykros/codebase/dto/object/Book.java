package com.sykros.codebase.dto.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("pages")
    private int pages;
}