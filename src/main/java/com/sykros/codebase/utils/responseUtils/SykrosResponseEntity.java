package com.sykros.codebase.utils.responseUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class SykrosResponseEntity<T> extends ResponseEntity<T> {

    public SykrosResponseEntity(HttpStatusCode status) {
        super(status);
    }

    public static SykrosResponseEntity<?> buildResponseEntity(ResponseMessage<?> responseMessage) {
        return new SykrosResponseEntity<>(responseMessage,responseMessage.getStatusCode());
    }

    public static SykrosResponseEntity<?> responseError(ErrorResponseMessage<?> errorResponseMessage) {
        return new SykrosResponseEntity<>(errorResponseMessage,errorResponseMessage.getStatusCode());
    }

    public SykrosResponseEntity(T body, HttpStatusCode status) {
        super(body, status);
    }

    public SykrosResponseEntity(MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(headers, status);
    }

    public SykrosResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(body, headers, status);
    }

    public SykrosResponseEntity(T body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }

}
