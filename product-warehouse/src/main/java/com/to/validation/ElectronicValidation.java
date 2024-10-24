package com.to.validation;

import com.to.exception.ElectronicValidationException;
import com.to.exception.NameValidationException;
import com.to.ordermanagementservice.entity.Electronic;

import java.time.Year;

public class ElectronicValidation extends ProductValidation <Electronic> {
    @Override
    public void doValidateInternal (Electronic electronic){
        if (electronic.getBrand().length() > 255 || electronic.getBrand().isEmpty()){
            throw new ElectronicValidationException("Length of brand name " + electronic.getBrand() +
                    " must not be empty and longer that 255 characters");
        }
        if (electronic.getWarrantyPeriod().getYear() > Year.now().getValue()){
            throw new ElectronicValidationException("the year " + electronic.getWarrantyPeriod().getYear() +
                    " must be real");
        }

    }
}
