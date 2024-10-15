package com.to.exception;

public class YearValidationException extends RuntimeException{
    public YearValidationException (int year){
        super("the year " + year + " must be real");
    }
}
