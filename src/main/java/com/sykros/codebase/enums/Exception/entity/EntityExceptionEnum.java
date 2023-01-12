package com.sykros.codebase.enums.Exception.entity;

import com.sykros.codebase.enums.Entity;
import com.sykros.codebase.enums.message.api_response.BookDomain;
import com.sykros.codebase.enums.message.api_response.RoleDomain;
import lombok.Getter;

@Getter
public enum EntityExceptionEnum {

    ROLE_NOT_FOUND_EXCEPTION(RoleDomain.ROLE_NOT_FOUND.getMessage()),

    BOOK_NOT_FOUND_EXCEPTION(BookDomain.BOOK_NOT_FOUND.getMessage());

    private final String exceptionMessage;

    EntityExceptionEnum(String message) {
        this.exceptionMessage = message;
    }


}
