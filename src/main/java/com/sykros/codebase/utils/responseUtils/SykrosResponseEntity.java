package com.sykros.codebase.utils.responseUtils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

@Getter
@Setter
public class SykrosResponseEntity<T> extends ResponseEntity<T> {

    public SykrosResponseEntity(HttpStatusCode status) {
        super(status);
    }
    T data;
    String message;

    public static SykrosResponseEntity<?> buildResponseEntity(ResponseMessage<?> responseMessage) {
        return new SykrosResponseEntity<>(responseMessage, responseMessage.getStatusCode());
    }

    public static SykrosResponseEntity<?> responseError(ErrorResponseMessage<?> errorResponseMessage) {
        return new SykrosResponseEntity<>(errorResponseMessage, errorResponseMessage.getStatusCode());
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

    public static class Builder<T>{

        ResponseMessage<T> responseComponent;



        public SykrosResponseEntity<ResponseMessage<T>> buildResponseEntity(ResponseMessage.Builder<T> builder) {
            ResponseMessage<T> respMsg = new ResponseMessage<>(builder);
            return new SykrosResponseEntity<>(respMsg,respMsg.statusCode);
        }

        public ResponseMessage.Builder<T> withResponseComponent() {
            return new ResponseMessage.Builder<>();
        }
    }

}
