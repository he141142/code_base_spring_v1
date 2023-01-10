package com.sykros.codebase.enums.message.api_response;

import lombok.Getter;

public enum RoleDomain {
    ROLE_NOT_FOUND("Error can't find Role");
    @Getter
    String message;
    RoleDomain(String message) {
        this.message = message;
    }
}
