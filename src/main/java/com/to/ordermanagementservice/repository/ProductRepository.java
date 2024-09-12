package com.to.ordermanagementservice.repository;

import com.to.ordermanagementservice.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    Product getProductById(int id);
    Map<Integer,Product> getProductsByIds(List<Integer> ids);
}
