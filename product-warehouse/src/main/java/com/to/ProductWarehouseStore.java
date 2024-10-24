package com.to;

import com.to.ordermanagementservice.entity.Product;
import com.to.validation.ValidationFactory;
import com.to.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductWarehouseStore {
    private List<Product> products = new ArrayList<>();
    private final ValidationService validationService;

    @Autowired
    public ProductWarehouseStore(ValidationService validationService) {
        this.validationService = validationService;
    }

    public void addProduct(Product product) {
        //add validation
        //check count of product

    }
    private void isValid (Product product){
        validationService.validation(product);
    }
}
