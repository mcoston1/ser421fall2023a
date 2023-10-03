package com.example.restlab.model.exceptions;

@SuppressWarnings("serial")
public class RestInternalException extends RuntimeException{
    
    public RestInternalException() {
        this("There was an internal server error with the rest service");
    }

    public RestInternalException(String message) {
        super(message);
    }

    public RestInternalException(Throwable cause) {
        super(cause);
    }

    public RestInternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestInternalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
