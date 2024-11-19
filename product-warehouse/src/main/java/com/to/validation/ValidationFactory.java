package com.to.validation;

import com.to.ordermanagementservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ValidationFactory {
    private final Map<Class<?>, ProductValidation<?>> validationMap;

    @Autowired
    public ValidationFactory(List<ProductValidation<?>> validationsList) {
        this.validationMap = validationsList.stream().collect(Collectors.toMap(ProductValidation::supports
                ,validation -> validation));
    }

    public <T extends Product> ProductValidation<T> getValidation(Class<T> clazz) {
        return (ProductValidation<T>) validationMap.get(clazz);
    }
}
