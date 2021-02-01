package com.arafa.books.exception;

public class CustomRequestException extends RuntimeException{

    public CustomRequestException(String message) {
        super(message);
    }

    public CustomRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
