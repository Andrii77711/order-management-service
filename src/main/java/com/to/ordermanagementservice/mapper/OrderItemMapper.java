package com.to.ordermanagementservice.mapper;

import com.to.ordermanagementservice.dto.OrderItemDetails;
import com.to.ordermanagementservice.dto.ProductDetails;
import com.to.ordermanagementservice.entity.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemDetails toOrderItemDetails(OrderItem orderItem, ProductDetails productDetails) {
        OrderItemDetails orderItemDetails = new OrderItemDetails();
        orderItemDetails.setId(orderItem.getId());
        orderItemDetails.setOrderId(orderItem.getOrderId());
        orderItemDetails.setUpdatedAt(orderItem.getUpdatedAt());
        orderItemDetails.setCreatedAt(orderItem.getCreatedAt());
        orderItemDetails.setProduct(productDetails);
        orderItemDetails.setQuantity(orderItem.getQuantity());
        return orderItemDetails;
    }


}
