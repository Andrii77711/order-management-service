package com.to.ordermanagementservice.repository;

import com.to.ordermanagementservice.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> getAllOrders();
    Optional<Order> getOrderByID(int id);

}
