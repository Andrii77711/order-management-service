package com.to.ordermanagementservice.repository;

import com.to.ordermanagementservice.entity.Product;

public interface ProductRepository {
    Product getProductById(int id);
}
