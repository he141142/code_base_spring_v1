package com.sykros.codebase.exception.violations;

public class ViolationEntity {
    private final String fieldName;
    private final String msg;

    public ViolationEntity(String fieldName, String msg) {
        this.fieldName = fieldName;
        this.msg = msg;
    }
    public String getFieldName() {
        return fieldName;
    }

    public String getMsg() {
        return msg;
    }
}
