package com.to.ordermanagementservice.repository;

import com.to.ordermanagementservice.entity.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> getAllOrders();

}
