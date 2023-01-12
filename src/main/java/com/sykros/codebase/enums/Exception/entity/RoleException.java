package com.sykros.codebase.enums.Exception.entity;

import com.sykros.codebase.enums.message.api_response.RoleDomain;

public enum RoleException {
    ROLE_NOT_FOUND_EXCEPTION(RoleDomain.ROLE_NOT_FOUND),
    ;

    RoleDomain roleDomain;
    RoleException(RoleDomain message) {
        this.roleDomain = message;
    }
}
