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
    public void addProduct(Product product){
         basket.add(product);
    }

    @Override
    public List<String> getDescriptionsForAllProducts(){
        List<String> result = new ArrayList<>();
        for (Product product : basket){
            result.add(product.description());
        }

        return result;
    }

}
