package com.to.exception;

public class WarrantyPeriodValidationException extends RuntimeException{
    public WarrantyPeriodValidationException (int year){
        super("The warranty period " + year + "must be positive");
    }
}
