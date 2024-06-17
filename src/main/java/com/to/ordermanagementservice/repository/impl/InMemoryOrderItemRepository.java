package com.to.ordermanagementservice.repository.impl;

import com.to.ordermanagementservice.entity.OrderItem;
import com.to.ordermanagementservice.exception.UnimplementedException;
import com.to.ordermanagementservice.repository.OrderItemRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryOrderItemRepository implements OrderItemRepository {

    private final List<OrderItem> orderItems;

    public InMemoryOrderItemRepository() {
        OrderItem orderItem11 = new OrderItem();
        orderItem11.setId(11);
        orderItem11.setOrderId(1);
        orderItem11.setUserId(1); // Установить userId
        orderItem11.setProductId(1);
        orderItem11.setQuantity(10);
        orderItem11.setPrice(new BigDecimal("12.50"));

        OrderItem orderItem21 = new OrderItem();
        orderItem21.setId(21);
        orderItem21.setOrderId(2);
        orderItem21.setUserId(2); // Установить userId
        orderItem21.setProductId(21);
        orderItem21.setQuantity(110);
        orderItem21.setPrice(new BigDecimal("42.50"));

        OrderItem orderItem22 = new OrderItem();
        orderItem22.setId(22);
        orderItem22.setOrderId(2);
        orderItem22.setUserId(2); // Установить userId
        orderItem22.setProductId(121);
        orderItem22.setQuantity(4);
        orderItem22.setPrice(new BigDecimal("110"));

        this.orderItems = List.of(
                orderItem11,
                orderItem21,
                orderItem22
        );
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Integer orderId) {
        return orderItems.stream()
                .filter(orderItem -> orderItem.getOrderId().equals(orderId))
                .collect(Collectors.toList());
    }
}