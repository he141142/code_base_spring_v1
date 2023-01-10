package com.sykros.codebase.exception.entity;

public class RoleException extends EntityException {
    public RoleException(String message) {
        super(message);
    }

    public RoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class builder extends EntityException.builder<builder>{
        String exceptionMessage;

        public RoleException build() {
            return new RoleException(this.exceptionMessage);
        }

    }
}
