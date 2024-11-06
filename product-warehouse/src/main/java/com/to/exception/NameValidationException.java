package com.to.exception;

public class NameValidationException extends ProductValidationException {
    public NameValidationException(String name) {
        super("Length of name " + name + " must not be empty and longer that 255 characters");
    }
}
