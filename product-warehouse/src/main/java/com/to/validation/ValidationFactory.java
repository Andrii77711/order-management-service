package com.to.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ValidationFactory {
    private final Map<Class<?>,Validation<?>> validationMap = new HashMap<>();

    @Autowired
    public ValidationFactory (List<Validation<?>> validations){
        for (Validation<?>validation: validations){
            this.validationMap.put(validation.getClass(),validation);
        }
    }

    public <T> Validation<T> getValidation(Class<T> clazz){
        return (Validation<T>) validationMap.get(clazz);
    }
}
