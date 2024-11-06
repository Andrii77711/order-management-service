package com.to.exception;

public class ClothingValidationException extends RuntimeException {
    public ClothingValidationException(String name) {
        super(name);
    }
}
