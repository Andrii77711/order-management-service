package com.to.ordermanagementservice.repository;

import com.to.ordermanagementservice.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    Map<Integer, Product> getProductsByIds(List<Integer> ids);
}
