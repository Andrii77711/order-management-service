package com.to.ordermanagementservice.repository;

import com.to.ordermanagementservice.entity.Product;

import java.util.List;

public interface BasketRepository {
    void addProduct(Product product);

    List<String> getDescriptionsForAllProducts();
}
