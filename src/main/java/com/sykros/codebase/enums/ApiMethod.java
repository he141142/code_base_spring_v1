package com.sykros.codebase.enums;

public enum ApiMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT");

    private String name;

    ApiMethod(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
