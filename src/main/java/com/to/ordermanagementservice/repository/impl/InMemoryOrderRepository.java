package com.to.ordermanagementservice.repository.impl;

import com.to.ordermanagementservice.entity.Order;
import com.to.ordermanagementservice.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.ORDER_ID_1;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.ORDER_ID_2;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.ORDER_ID_3;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.USER_ID_1;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.USER_ID_2;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.USER_ID_3;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private final List<Order> orders;
    public InMemoryOrderRepository() {
        orders = List.of(
                createOrder(ORDER_ID_1, USER_ID_1),
                createOrder(ORDER_ID_2, USER_ID_2),
                createOrder(ORDER_ID_3, USER_ID_3)
        );
    }

    @Override
    public List<Order> getAllOrders() {
        return List.copyOf(orders);
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
