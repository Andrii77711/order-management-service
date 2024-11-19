package com.to.validation;

import com.to.exception.ProductValidationException;
import com.to.ordermanagementservice.entity.Grocery;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GroceryValidation extends ProductValidation<Grocery> {
    @Override
    public Class<Grocery> supports() {
        return Grocery.class;
    }

    @Override
    public void doValidateInternal(Grocery grocery) {
        if (LocalDate.now().isBefore(grocery.getExpiryDate())) {
            throw new ProductValidationException("the date need " + grocery.getExpiryDate() + " correct ");
        }
    }
}
