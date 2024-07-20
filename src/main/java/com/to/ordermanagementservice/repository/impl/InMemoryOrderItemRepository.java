package com.to.ordermanagementservice.repository.impl;

import com.to.ordermanagementservice.entity.OrderItem;
import com.to.ordermanagementservice.repository.OrderItemRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.ORDER_ID_1;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.ORDER_ID_2;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.ORDER_ITEM_ID_11;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.ORDER_ITEM_ID_21;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.ORDER_ITEM_ID_22;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.ORDER_ITEM_QUANTITY_WITH_ID_11;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.ORDER_ITEM_QUANTITY_WITH_ID_21;
import static com.to.ordermanagementservice.utils.InMemoryRepositoryUtils.ORDER_ITEM_QUANTITY_WITH_ID_22;

@Repository
public class InMemoryOrderItemRepository implements OrderItemRepository {

    private final List<OrderItem> orderItems;

    public InMemoryOrderItemRepository() {
        OrderItem orderItem11 = new OrderItem();
        orderItem11.setId(ORDER_ITEM_ID_11);
        orderItem11.setOrderId(ORDER_ID_1);
        orderItem11.setProductId(1);
        orderItem11.setQuantity(ORDER_ITEM_QUANTITY_WITH_ID_11);
        orderItem11.setCreatedAt(OffsetDateTime.now());
        orderItem11.setUpdatedAt(OffsetDateTime.now());
        orderItem11.setPrice(new BigDecimal("12.50"));

        OrderItem orderItem21 = new OrderItem();
        orderItem21.setId(ORDER_ITEM_ID_21);
        orderItem21.setOrderId(ORDER_ID_2);
        orderItem21.setProductId(2);
        orderItem21.setQuantity(ORDER_ITEM_QUANTITY_WITH_ID_21);
        orderItem21.setCreatedAt(OffsetDateTime.now());
        orderItem21.setUpdatedAt(OffsetDateTime.now());
        orderItem21.setPrice(new BigDecimal("42.50"));

        OrderItem orderItem22 = new OrderItem();
        orderItem22.setId(ORDER_ITEM_ID_22);
        orderItem22.setOrderId(ORDER_ID_2);
        orderItem22.setProductId(2);
        orderItem22.setQuantity(ORDER_ITEM_QUANTITY_WITH_ID_22);
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
