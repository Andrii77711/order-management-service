package com.to.ordermanagementservice.repository.impl;

import com.to.ordermanagementservice.entity.Order;
import com.to.ordermanagementservice.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private final List<Order> orders;

    public InMemoryOrderRepository() {
        orders = List.of(
                createOrder(1, 1),
                createOrder(2, 2),
                createOrder(3, 3)
        );
    }

    @Override
    public List<Order> getAllOrders() {
        return List.copyOf(orders);
    }

    private static Order createOrder(int id, int userId) {
        Order order = new Order();
        order.setId(id);
        order.setuserId(userId); // Добавить id клиента чтобы добовлялся id человека !!!
        order.setCreatedAt(OffsetDateTime.now());
        return order;
    }
}
