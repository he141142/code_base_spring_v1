package com.sykros.codebase.enums.message.api_response;

import lombok.Getter;

public enum BookDomain {
    CREATE_SUCCESSFULLY("Create Book Successfully"),
    BOOK_NOT_FOUND("Sorry, we can't take the book");

    @Getter
    private final String message;

    BookDomain(String message) {
        this.message = message;
    }
}
