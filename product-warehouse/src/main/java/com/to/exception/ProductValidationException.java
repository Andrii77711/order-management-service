package com.to.exception;

public class ProductValidationException extends RuntimeException{
    public  ProductValidationException (String text){
       super(text);
    }
}
