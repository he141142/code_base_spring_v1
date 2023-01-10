package com.sykros.codebase.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sykros.codebase.dto.object.Book;
import jakarta.validation.Valid;

public class AddBookToInventoryResponse {
    @JsonProperty("inventory_id")
    Long inventoryId;

    @JsonProperty("book")
    @Valid Book book;
}
