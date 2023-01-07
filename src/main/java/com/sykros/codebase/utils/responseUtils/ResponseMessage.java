package com.sykros.codebase.utils.responseUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseMessage<T> {
    @Getter
    @JsonProperty("http_sattus")
    HttpStatus statusCode = HttpStatus.NOT_FOUND;


    @JsonProperty("data")
    T data = null;

    @JsonProperty("message")
    String message = "";


    public ResponseMessage(Builder<T> builder){
        this.message = builder.message;
        this.data=builder.data;
        this.statusCode = builder.statusCode;
    }

    public ResponseMessage(){
    }


    public static class Builder<T>{
        HttpStatus statusCode;
        T data;
        String message;


        public Builder<T> setData(T data) {
            this.data = data;
            return this;
        }


        public Builder<T> status(HttpStatus code) {
            this.statusCode = code;
            return this;
        }

        public Builder<T> withMessage(String message) {
            this.message = message;
            return this;
        }


        public ResponseMessage<T> build(){
            return new ResponseMessage<>(this);
        }

        public ResponseMessage<T> buildT(){
            return new ResponseMessage<>(this);
        }

        public SykrosResponseEntity<ResponseMessage<T>> buildResponseEntity(){
            return new SykrosResponseEntity.Builder<T>().buildResponseEntity(this.data,this.statusCode,this.message);
        }
    }
}
