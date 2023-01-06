package com.sykros.codebase.utils.responseUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

public class ResponseMessage<T> {
    @Getter
    @JsonProperty("http_sattus")
    HttpStatusCode statusCode;

    @JsonProperty("data")
    T data;

    @JsonProperty("message")
    String message;


    public ResponseMessage(Builder<T> builder){
        this.message = builder.message;
        this.data=builder.data;
        this.statusCode = builder.statusCode;
    }

    public ResponseMessage(){
    }
    
    
    public static class Builder<T>{
        HttpStatusCode statusCode;
        T data;
        String message;


        public Builder<?> setData(T data) {
            this.data = data;
            return this;
        }

        public Builder<?> status(HttpStatusCode code) {
            this.statusCode = code;
            return this;
        }

        public Builder<?> withMessage(String message) {
            this.message = message;
            return this;
        }

        public ResponseMessage<?> build(){
            return new ResponseMessage<>(this);
        }
        
    }
}
