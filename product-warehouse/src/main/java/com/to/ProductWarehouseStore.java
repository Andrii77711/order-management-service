package com.to;

import com.to.ordermanagementservice.entity.Product;
import com.to.validation.ValidationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductWarehouseStore {
    private List<Product> products = new ArrayList<>();
    private final ValidationFactory validationFactory;

    @Autowired
    public ProductWarehouseStore(ValidationFactory validationFactory) {
        this.validationFactory = validationFactory;
    }

    public void addProduct(Product product) {
        //add validation
        //check count of product

    }
    private Boolean isValid (Product product){
        return validationFactory.getValidation()
    }
}
