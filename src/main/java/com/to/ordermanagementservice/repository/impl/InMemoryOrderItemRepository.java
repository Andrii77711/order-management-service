package com.to.ordermanagementservice.repository.impl;

import com.to.ordermanagementservice.entity.OrderItem;
import com.to.ordermanagementservice.repository.OrderItemRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryOrderItemRepository implements OrderItemRepository {

    private final List<OrderItem> orderItems;

    public InMemoryOrderItemRepository() {
        OrderItem orderItem11 = new OrderItem();
        orderItem11.setId(1);
        orderItem11.setOrderId(1);
        orderItem11.setProductId(1);
        orderItem11.setQuantity(10);
        orderItem11.setCreatedAt(OffsetDateTime.now());
        orderItem11.setUpdatedAt(OffsetDateTime.now());
        orderItem11.setPrice(new BigDecimal("12.50"));

        OrderItem orderItem21 = new OrderItem();
        orderItem21.setId(2);
        orderItem21.setOrderId(2);
        orderItem21.setProductId(21);
        orderItem21.setQuantity(110);
        orderItem21.setCreatedAt(OffsetDateTime.now());
        orderItem21.setUpdatedAt(OffsetDateTime.now());
        orderItem21.setPrice(new BigDecimal("42.50"));

        OrderItem orderItem22 = new OrderItem();
        orderItem22.setId(2);
        orderItem22.setOrderId(2);
        orderItem22.setProductId(121);
        orderItem22.setQuantity(4);
        orderItem22.setCreatedAt(OffsetDateTime.now());
        orderItem22.setUpdatedAt(OffsetDateTime.now());
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
