package com.example.rentacar.core.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
    //custom exceptionlar olabilir. Runtime Exceptiona -> super() oraya gidiyor.
}
