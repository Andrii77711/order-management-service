package com.to.ordermanagementservice.repository;

import com.to.ordermanagementservice.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository {

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

}
