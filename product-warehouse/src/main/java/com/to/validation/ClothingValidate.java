package com.to.validation;

import com.to.exception.ProductValidationException;
import com.to.ordermanagementservice.entity.Clothing;
import org.springframework.stereotype.Component;

import static com.to.utils.Constant.MAX_TEXT_SIZE;

@Component
public class ClothingValidate extends ProductValidate<Clothing> {
    @Override
    public Class<Clothing> supports() {
        return Clothing.class;
    }

    @Override
    public void doValidateInternal(Clothing clothing) throws ProductValidationException {
        if (clothing.getSize() < 1) {
            throw new ProductValidationException("the size " + clothing.getSize()
                    + " must be positive");
        }
        if (clothing.getColor().length() > MAX_TEXT_SIZE || clothing.getColor().isEmpty()) {
            throw new ProductValidationException("Length of color " + clothing.getColor()
                    + " must not be empty and longer that 255 characters");
        }
    }
}
