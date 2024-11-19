package com.to;

import com.to.ordermanagementservice.entity.Product;

import java.util.List;

public interface ProductWarehouse {
    void addProduct (Product product);
    List<Product> getProducts();

}
