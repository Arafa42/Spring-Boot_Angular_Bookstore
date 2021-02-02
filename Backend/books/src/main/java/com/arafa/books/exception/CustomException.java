package com.arafa.books.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class CustomException{
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;

    public CustomException(String message, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }

    public String getMessage() {
        return message;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }
}
