package com.to.validation;

import com.to.exception.ExpiryDateException;
import com.to.exception.NameValidationException;
import com.to.ordermanagementservice.entity.Grocery;

import java.time.LocalDate;

public class GroceryValidation implements Validation <Grocery> {
    @Override
    public Boolean isValid (Grocery grocery){
        if (grocery.getName().length() > 255 || grocery.getName().isEmpty()){
            throw new NameValidationException(grocery.getName());
        }
        if (LocalDate.now().isBefore(grocery.getExpiryDate())){
            throw new ExpiryDateException(grocery.getExpiryDate());
        }
        return true;
    }
}
