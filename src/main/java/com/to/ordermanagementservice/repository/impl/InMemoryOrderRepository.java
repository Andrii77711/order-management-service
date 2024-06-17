package com.to.ordermanagementservice.repository.impl;

import com.to.ordermanagementservice.entity.Order;
import com.to.ordermanagementservice.repository.OrderItemRepository;
import com.to.ordermanagementservice.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private final List<Order> orders;
    private final OrderItemRepository orderItemRepository;
    public InMemoryOrderRepository() {
        this.orderItemRepository = new InMemoryOrderItemRepository();
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

    private Order createOrder(int id, int userId) {
        Order order = new Order();
        order.setId(id);
        order.setUserId(userId); // Добавить id клиента чтобы добовлялся id человека (completed)
        order.setCreatedAt(OffsetDateTime.now());
        order.setUpdatedAt(OffsetDateTime.now());
        order.setOrderItems(orderItemRepository.getOrderItemsByOrderId(id));
        return order;
    }
}
