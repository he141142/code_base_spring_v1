package com.sykros.codebase.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Date;

public class ErrorEntity<T extends Exception> {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timeStamp;

    @JsonProperty("message")
    private String message;

    @JsonIgnore
    private String stackStrace;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getStackStrace() {
        return stackStrace;
    }

    public ErrorEntity(T exception){
        this.timeStamp = new Date();
        this.message = exception.getMessage();
        this.stackStrace = Arrays.toString(exception.getStackTrace());
    }
}
