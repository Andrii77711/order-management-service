package com.to.validation;

import com.to.exception.BrandValidationException;
import com.to.exception.NameValidationException;
import com.to.exception.WarrantyPeriodValidationException;
import com.to.exception.YearValidationException;
import com.to.ordermanagementservice.entity.Electronic;

import java.time.Year;

public class ElectronicValidation implements Validation <Electronic> {
    @Override
    public Boolean isValid (Electronic electronic){
        if (electronic.getName().length() > 255 || electronic.getName().isEmpty()){
            throw new NameValidationException(electronic.getName());
        }
        if (electronic.getBrand().length() > 255 || electronic.getBrand().isEmpty()){
            throw new BrandValidationException(electronic.getBrand());
        }
        if (electronic.getWarrantyPeriod().getYear() > Year.now().getValue()){
            throw new YearValidationException(electronic.getWarrantyPeriod().getYear());
        }

        return true;
    }
}
