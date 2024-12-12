package com.to;

import com.to.ordermanagementservice.entity.Product;
import com.to.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductWarehouseFacade {
    private final ValidationService validationService;
    private final ProductWarehouse productWarehouse;

    @Autowired
    public ProductWarehouseFacade(ValidationService validationService, ProductWarehouse productWarehouse) {
        this.validationService = validationService;
        this.productWarehouse = productWarehouse;
    }

    public void addProduct(Product product) {
        isValid(product);
        productWarehouse.addProduct(product);
    }

    private void isValid(Product product) {
        validationService.validation(product);
    }

    public List<Product> getProducts() {
        return productWarehouse.getProducts();
    }
}
