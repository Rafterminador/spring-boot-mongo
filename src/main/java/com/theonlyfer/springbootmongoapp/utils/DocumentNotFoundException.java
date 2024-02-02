package com.theonlyfer.springbootmongoapp.utils;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DocumentNotFoundException extends RuntimeException {
    private HttpStatus httpStatus;

    public DocumentNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}

