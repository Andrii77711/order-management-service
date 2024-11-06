package com.to.validation;

import com.to.exception.ClothingValidationException;
import com.to.ordermanagementservice.entity.Clothing;

import static com.to.utils.Constant.MAX_TEXT_SIZE;

public class ClothingValidation extends ProductValidation<Clothing> {
    @Override
    public void doValidateInternal(Clothing clothing) throws ClothingValidationException {
        if (clothing.getSize() < 1) {
            throw new ClothingValidationException("the size " + clothing.getSize()
                    + " must be positive");
        }
        if (clothing.getColor().length() > MAX_TEXT_SIZE || clothing.getColor().isEmpty()) {
            throw new ClothingValidationException("Length of color " + clothing.getColor()
                    + " must not be empty and longer that 255 characters");
        }
    }
}
