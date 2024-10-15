package com.to.exception;

public class BrandValidationException extends RuntimeException{
    public BrandValidationException(String name){
        super("Length of brand name " + name + " must not be empty and longer that 255 characters");
    }
}
