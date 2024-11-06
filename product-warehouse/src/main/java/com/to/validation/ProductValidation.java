package com.to.validation;

import com.to.exception.ProductValidationException;
import com.to.ordermanagementservice.entity.Product;

public abstract class ProductValidation<T extends Product> {
    public void validation(T product) {
        if (product.getName() == null) {
            throw new ProductValidationException("Product name is required");
        }
        if (product.getPrice() == null) {
            throw new ProductValidationException("Product price is required");
        }
        doValidateInternal(product);
    }

    abstract void doValidateInternal(T product);
}
