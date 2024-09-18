package com.to.ordermanagementservice.repository.impl;

import com.to.ordermanagementservice.entity.Clothing;
import com.to.ordermanagementservice.entity.Electronic;
import com.to.ordermanagementservice.entity.Grocery;
import com.to.ordermanagementservice.entity.Product;
import com.to.ordermanagementservice.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> products;

    public InMemoryProductRepository() {
        products = new ArrayList<>();
        Product electronic1 = new Electronic(1,
                "TV",
                new BigDecimal(50000),
                "SAMSUNG",
                LocalDate.now());
        products.add(electronic1);
        Grocery grocery1 = new Grocery(2,
                "bread",
                new BigDecimal(23),
                LocalDate.now());
        products.add(grocery1);
        Clothing clothing1 = new Clothing(3,
                "ClubTS",
                new BigDecimal(20),
                50,
                "Blue");
        products.add(clothing1);
    }

    @Override
    public Map<Integer, Product> getProductsByIds(List<Integer> productIds) {
        return products.stream()
                .filter(product -> productIds.contains(product.getId()))
                .collect(Collectors.toMap(Product::getId, product -> product));
    }
}
