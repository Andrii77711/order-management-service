package com.to.validation;

import com.to.ordermanagementservice.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ValidationFactory {
    private final Map<Class<?>,ProductValidation<?>> validationMap = new HashMap<>();

    @Autowired
    public ValidationFactory (){
        validationMap.put(Book.class,new BookValidation());
        validationMap.put(Clothing.class,new ClothingValidation());
        validationMap.put(Electronic.class,new ElectronicValidation());
        validationMap.put(Grocery.class,new GroceryValidation());
    }

    public <T extends Product> ProductValidation<T> getValidation(Class<T> clazz){
        return (ProductValidation<T>) validationMap.get(clazz);
    }
}
