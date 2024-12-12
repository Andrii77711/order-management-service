package com.to;

import com.to.exception.CapacityValidationException;
import com.to.ordermanagementservice.entity.Book;
import com.to.ordermanagementservice.entity.Clothing;
import com.to.ordermanagementservice.entity.Electronic;
import com.to.ordermanagementservice.entity.Grocery;
import com.to.ordermanagementservice.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryProductWarehouse implements ProductWarehouse {
    private List<Product> products = new ArrayList<>();
    private static final int BOOK_MAX_CAPACITY = 5;
    private static final int CLOTHING_MAX_CAPACITY = 5;
    private static final int ELECTRONIC_MAX_CAPACITY = 5;
    private static final int GROCERY_MAX_CAPACITY = 5;
    @Override
    public void addProduct(Product product) {
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

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
