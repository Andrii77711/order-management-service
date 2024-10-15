package com.to.validation;

import com.to.exception.ColorValidationException;
import com.to.exception.NameValidationException;
import com.to.exception.SizeValidationException;
import com.to.ordermanagementservice.entity.Clothing;

public class ClothingValidation implements Validation <Clothing>{
    @Override
    public Boolean isValid (Clothing clothing) throws SizeValidationException {
        if (clothing.getName().length() > 255 || clothing.getName().isEmpty()){
            throw new NameValidationException(clothing.getName());
        }
        if (clothing.getSize() < 1) {
            throw new SizeValidationException(clothing.getSize());
        }
        if (clothing.getColor().length() > 255 || clothing.getColor().isEmpty()){
            throw new ColorValidationException(clothing.getColor());
        }

        return true;
    }
}
