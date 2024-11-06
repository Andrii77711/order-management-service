package com.to.exception;

public class ElectronicValidationException extends RuntimeException {
    public ElectronicValidationException(String name) {
        super(name);
    }
}
