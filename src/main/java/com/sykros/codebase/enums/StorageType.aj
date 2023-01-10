package com.sykros.codebase.enums;

public enum StorageType {
    CLOUD("CLOUD DEV://"),
    LOCAL("127.0.0.1://");

    private final String url;

    StorageType(String url) {
        this.url = url;
    }
}
