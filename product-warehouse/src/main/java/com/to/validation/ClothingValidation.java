package com.to.validation;

import com.to.exception.ClothingValidationException;
import com.to.exception.NameValidationException;
import com.to.ordermanagementservice.entity.Clothing;

public class ClothingValidation extends ProductValidation <Clothing>{
    @Override
    public void doValidateInternal (Clothing clothing) throws ClothingValidationException {
        if (clothing.getSize() < 1) {
            throw new ClothingValidationException("the size " + clothing.getSize() +
                    " must be positive");
        }
        if (clothing.getColor().length() > 255 || clothing.getColor().isEmpty()){
            throw new ClothingValidationException("Length of color " + clothing.getColor() +
                    " must not be empty and longer that 255 characters");
        }
    }
}
