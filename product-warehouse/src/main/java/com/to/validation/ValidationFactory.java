package com.to.validation;

import com.to.ordermanagementservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ValidationFactory {
    private final Map<Class<?>, ProductValidate<?>> validationMap;

    @Autowired
    public ValidationFactory(List<ProductValidate<?>> validationsList) {
        this.validationMap = validationsList.stream().collect(Collectors.toMap(ProductValidate::supports,
                validation -> validation));
    }

    public <T extends Product> ProductValidate<T> getValidation(Class<T> clazz) {
        return (ProductValidate<T>) validationMap.get(clazz);
    }
}
