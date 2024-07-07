package com.to.ordermanagementservice.repository;

import com.to.ordermanagementservice.entity.Product;

import java.util.List;

public interface BasketRepository {
    public void addProduct(Product product);
    public List<String> getDescriptionsForAllProducts();
}
