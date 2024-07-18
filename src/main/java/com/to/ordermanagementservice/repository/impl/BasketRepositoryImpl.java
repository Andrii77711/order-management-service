package com.to.ordermanagementservice.repository.impl;

import com.to.ordermanagementservice.entity.Product;
import com.to.ordermanagementservice.repository.BasketRepository;

import java.util.ArrayList;
import java.util.List;

public class BasketRepositoryImpl implements BasketRepository {
    private List<Product> basket = new ArrayList<>();

    public List<Product> getBasket() {
        return basket;
    }

    @Override
    public void addProduct(Product product) {
        if (product != null) {
            basket.add(product);
        }
    }

    @Override
    public List<String> getDescriptionsForAllProducts() {
        return basket.stream().map(Product::description).toList();
    }

}
