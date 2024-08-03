package com.to.ordermanagementservice.mapper;

import com.to.ordermanagementservice.dto.OrderDetails;
import com.to.ordermanagementservice.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDetails toOrderDetails(Order order) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(order.getId());
        orderDetails.setCustomerId(order.getUserId());
        orderDetails.setUpdatedAt(order.getUpdatedAt());
        orderDetails.setCreatedAt(order.getCreatedAt());
        return orderDetails;
    }
}
