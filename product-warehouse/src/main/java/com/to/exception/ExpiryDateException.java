package com.to.exception;

import java.time.LocalDate;

public class ExpiryDateException extends RuntimeException{
    public ExpiryDateException (LocalDate expiryDate){
        super("the date need " + expiryDate + " correct ");
    }
}
