package com.sykros.codebase.enums;

import lombok.Getter;

public enum Entity {
    ROLE("ROLE"),
    BOOK("BOOK"),
    INVENTORY("INVENTORY"),
    ACCOUNT("ACCOUNT");
    @Getter
    public final String entityName;
    Entity(String entityName) {
        this.entityName = entityName;
    }
}
