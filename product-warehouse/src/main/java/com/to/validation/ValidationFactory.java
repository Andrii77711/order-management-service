package com.to.validation;

import com.to.ordermanagementservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ValidationFactory {
    private final Map<Class<?>,ProductValidation<?>> validationMap = new HashMap<>();

    @Autowired
    public ValidationFactory (List<ProductValidation<?>> validations){
        for (ProductValidation<?>validation: validations){
            this.validationMap.put(validation.getClass(),validation);
        }
    }

    public <T extends Product> ProductValidation<T> getValidation(Class<T> clazz){
        return (ProductValidation<T>) validationMap.get(clazz);
    }
}
