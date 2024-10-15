package com.to.exception;

public class AuthorValidationException extends RuntimeException {
    public AuthorValidationException(String name){
        super("Length of Author name " + name + " must not be empty and longer that 255 characters");
    }
}
