package com.to.ordermanagementservice.repository.impl;

import com.to.ordermanagementservice.entity.Electronic;
import com.to.ordermanagementservice.entity.Product;
import com.to.ordermanagementservice.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> products;

    public InMemoryProductRepository() {
        products=new ArrayList<>();
        Product electronic1 = new Electronic(1,
                "TV",
                new BigDecimal(50000),
                "SAMSUNG",
                LocalDate.now());
        products.add(electronic1);
        Product electronic2 = new Electronic(2,
                "PS",
                new BigDecimal(25000),
                "SONY",
                LocalDate.now());
        products.add(electronic2);
        Product electronic3 = new Electronic(3,
                "Phone",
                new BigDecimal(300),
                "Nokia",
                LocalDate.now());
        products.add(electronic3);
    }

    @Override
    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not found product with id = " + id));
    }
}
