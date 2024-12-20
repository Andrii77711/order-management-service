package com.to.validation;

import com.to.ordermanagementservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationService {
    private final ValidationFactory validationFactory;

    @Autowired
    public ValidationService(ValidationFactory validationFactory) {
        this.validationFactory = validationFactory;
    }

    public <T extends Product> void validation(T product) {
        ProductValidate<T> validation = (ProductValidate<T>) validationFactory.getValidation(product.getClass());
        if (validation != null) {
            validation.validate(product);
        } else {
            throw new IllegalArgumentException("Validation not found");
        }
    }

}
