package com.sykros.codebase.enums.Exception.entity;

import lombok.Getter;

public enum UserExceptionEnum {
    USER_NOT_FOUND("sorry, we cant found user"),
    ;
    @Getter
    private final String message;
    UserExceptionEnum(String message) {
        this.message = message;
    }
}
