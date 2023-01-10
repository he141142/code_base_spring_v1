package com.sykros.codebase.enums.message.api_response;

import lombok.Getter;

public enum BookDomain {
    CREATE_SUCCESSFULLY("Create Book Successfully");


    @Getter
    private final String message;

    BookDomain(String message) {
        this.message = message;
    }
}
