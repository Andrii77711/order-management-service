package com.to.exception;

public class BookValidationException extends RuntimeException {
    public BookValidationException(String name) {
        super(name);
    }
}
