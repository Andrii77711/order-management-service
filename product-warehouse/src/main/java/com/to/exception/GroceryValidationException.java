package com.to.exception;

public class GroceryValidationException extends RuntimeException {
    public GroceryValidationException(String name) {
        super(name);
    }
}
