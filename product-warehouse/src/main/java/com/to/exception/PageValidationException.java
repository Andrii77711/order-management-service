package com.to.exception;

public class PageValidationException extends RuntimeException{
    public PageValidationException(int pages){
        super("the count of page " + pages + " must be positive number");
    }
}
