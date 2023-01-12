package com.sykros.codebase.exception.entity;

import com.sykros.codebase.enums.Exception.entity.EntityExceptionEnum;

public class BookException extends EntityException {
    public BookException(EntityExceptionEnum entityExceptionEnum) {
        super(entityExceptionEnum);
    }

    public BookException(String message) {
        super(message);
    }

    public BookException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class builder extends EntityException.builder<builder>{
        public BookException build() {
            return new BookException(this.exceptionMessage);
        }
    }
}
