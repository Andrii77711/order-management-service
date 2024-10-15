package com.to.validation;

import org.springframework.beans.factory.annotation.Autowired;

public class ValidationService {
    private final ValidationFactory validationFactory;

    @Autowired
    public ValidationService(ValidationFactory validationFactory) {
        this.validationFactory = validationFactory;
    }
    public <T> Boolean isValid (T product){
        Validation<T> validation = (Validation<T>) validationFactory.getValidation(product.getClass());
        if (validation != null){
            return validation.isValid(product);
        }else {
            throw new IllegalArgumentException("Validation not found");
        }
    }

}
