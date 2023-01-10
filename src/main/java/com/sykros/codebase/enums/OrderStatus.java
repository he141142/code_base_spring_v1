package com.sykros.codebase.enums;

public enum OrderStatus {
    SUCCESS("PAYMENT SUCCESSFULLY"),
    FAILED("PAYMENT FAILED");

    private final String status;

    OrderStatus(String s) {
        this.status = s;
    }
}
