package com.to.validation;

import com.to.ordermanagementservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidationService {
    private final ValidationFactory validationFactory;

    @Autowired
    public ValidationService(ValidationFactory validationFactory) {
        this.validationFactory = validationFactory;
    }
    public <T extends Product> void validation (T product){
        ProductValidation<T> validation = (ProductValidation<T>) validationFactory.getValidation(product.getClass());
        if (validation != null){
            validation.validation(product);
        }else {
            throw new IllegalArgumentException("Validation not found");
        }
    }

}
