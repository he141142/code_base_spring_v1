package com.sykros.codebase.enums.message.configuration_log;

import io.jsonwebtoken.MalformedJwtException;
import lombok.Getter;

public enum JWT {
    SignatureException("Invalid JWT signature: {}"),
    MalformedJwtException("Invalid JWT token: {}"),
    ExpiredJwtException("JWT token is expired: {}"),
    UnsupportedJwtException("JWT token is unsupported: {}"),
    IllegalArgumentException("JWT claims string is empty: {}");

    @Getter
    String exceptionLog;

    JWT(String s) {
        this.exceptionLog = s;
    }
}
