package com.to.ordermanagementservice.repository.impl;

import com.to.ordermanagementservice.entity.Order;
import com.to.ordermanagementservice.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Order> getOrderByID(int id) {
        return orders.stream().filter(order -> order.getId().equals(id)).findAny();
    }

    private Order createOrder(int id, int userId) {
        Order order = new Order();
        order.setId(id);
        order.setUserId(userId);
        order.setCreatedAt(OffsetDateTime.now());
        order.setUpdatedAt(OffsetDateTime.now());
        return order;
    }
}
