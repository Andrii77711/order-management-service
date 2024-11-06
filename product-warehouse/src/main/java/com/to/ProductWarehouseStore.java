package com.to;

import com.to.exception.CapacityValidationException;
import com.to.ordermanagementservice.entity.Book;
import com.to.ordermanagementservice.entity.Clothing;
import com.to.ordermanagementservice.entity.Electronic;
import com.to.ordermanagementservice.entity.Grocery;
import com.to.ordermanagementservice.entity.Product;
import com.to.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductWarehouseStore {
    private List<Product> products = new ArrayList<>();
    private final ValidationService validationService;
    private static final int BOOK_MAX_CAPACITY = 5;
    private static final int CLOTHING_MAX_CAPACITY = 5;
    private static final int ELECTRONIC_MAX_CAPACITY = 5;
    private static final int GROCERY_MAX_CAPACITY = 5;

    @Autowired
    public ProductWarehouseStore(ValidationService validationService) {
        this.validationService = validationService;
    }

    public void addProduct(Product product) {
        isValid(product);
        hasCapacity(product);
        products.add(product);
    }

    private void hasCapacity(Product product) throws CapacityValidationException {
        long count = products.stream().filter(p -> p.getClass().equals(product.getClass())).count();
        if (product instanceof Book && count >= BOOK_MAX_CAPACITY) {
            throw new CapacityValidationException("can not add book more that " + BOOK_MAX_CAPACITY);
        } else if (product instanceof Clothing && count >= CLOTHING_MAX_CAPACITY) {
            throw new CapacityValidationException("can not add clothing more that " + CLOTHING_MAX_CAPACITY);
        } else if (product instanceof Electronic && count >= ELECTRONIC_MAX_CAPACITY) {
            throw new CapacityValidationException("can not add electronic more that " + ELECTRONIC_MAX_CAPACITY);
        } else if (product instanceof Grocery && count >= GROCERY_MAX_CAPACITY) {
            throw new CapacityValidationException("can not add grocery more that " + GROCERY_MAX_CAPACITY);
        }
    }

    private void isValid(Product product) {
        validationService.validation(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
