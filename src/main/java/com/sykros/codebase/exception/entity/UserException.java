package com.sykros.codebase.exception.entity;

import com.sykros.codebase.enums.Exception.entity.EntityExceptionEnum;
import com.sykros.codebase.enums.Exception.entity.UserExceptionEnum;

public class UserException extends EntityException {
    public UserException(EntityExceptionEnum entityExceptionEnum) {
        super(entityExceptionEnum);
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class builder extends EntityException.builder<builder> {
        public UserException build() {
            return new UserException(this.exceptionMessage);
        }

        public builder WithException(UserExceptionEnum exception){
            this.exceptionMessage = exception.getMessage();
            return this;
        }
    }
}
