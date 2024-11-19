package com.to.validation;

import com.to.exception.ProductValidationException;
import com.to.ordermanagementservice.entity.Electronic;
import org.springframework.stereotype.Component;

import java.time.Year;

import static com.to.utils.Constant.MAX_TEXT_SIZE;

@Component
public class ElectronicValidation extends ProductValidation<Electronic> {
    @Override
    public Class<Electronic> supports() {
        return Electronic.class;
    }

    @Override
    public void doValidateInternal(Electronic electronic) {
        if (electronic.getBrand().length() > MAX_TEXT_SIZE || electronic.getBrand().isEmpty()) {
            throw new ProductValidationException("Length of brand name " + electronic.getBrand()
                    + " must not be empty and longer that 255 characters");
        }
        if (electronic.getWarrantyPeriod().getYear() > Year.now().getValue()) {
            throw new ProductValidationException("the year " + electronic.getWarrantyPeriod().getYear()
                    + " must be real");
        }

    }
}
