package com.to.exception;

public class ColorValidationException extends RuntimeException {
    public ColorValidationException(String name){
        super("Length of color " + name + " must not be empty and longer that 255 characters");
    }
}
