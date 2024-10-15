package com.to.exception;

public class SizeValidationException extends RuntimeException {
    public SizeValidationException (int size){
        super("the size " + size + " must be positive");
    }
}
