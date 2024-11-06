package com.to.validation;

import com.to.exception.ElectronicValidationException;
import com.to.ordermanagementservice.entity.Electronic;

import java.time.Year;

import static com.to.utils.Constant.MAX_TEXT_SIZE;

public class ElectronicValidation extends ProductValidation<Electronic> {
    @Override
    public void doValidateInternal(Electronic electronic) {
        if (electronic.getBrand().length() > MAX_TEXT_SIZE || electronic.getBrand().isEmpty()) {
            throw new ElectronicValidationException("Length of brand name " + electronic.getBrand()
                    + " must not be empty and longer that 255 characters");
        }
        if (electronic.getWarrantyPeriod().getYear() > Year.now().getValue()) {
            throw new ElectronicValidationException("the year " + electronic.getWarrantyPeriod().getYear()
                    + " must be real");
        }

    }
}
