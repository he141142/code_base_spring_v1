package com.sykros.codebase.utils.responseUtils;

import com.sykros.codebase.exception.ErrorEntity;

public class ErrorResponseMessage<T extends Exception> extends ResponseMessage<T> {
    private ErrorEntity<T> error;
    public ErrorResponseMessage(T exception) {
        super();
        this.error = new ErrorEntity<>(exception);
    }
    public ErrorEntity<T>getErrorEntity(){
        return this.error;
    }
}
