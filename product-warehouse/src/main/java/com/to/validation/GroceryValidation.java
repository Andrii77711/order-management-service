package com.to.validation;

import com.to.exception.GroceryValidationException;
import com.to.exception.NameValidationException;
import com.to.ordermanagementservice.entity.Grocery;

import java.time.LocalDate;

public class GroceryValidation extends ProductValidation <Grocery> {
    @Override
    public void doValidateInternal (Grocery grocery){
        if (LocalDate.now().isBefore(grocery.getExpiryDate())){
            throw new GroceryValidationException("the date need " + grocery.getExpiryDate() + " correct ");
        }
    }
}
