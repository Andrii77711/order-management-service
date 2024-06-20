package com.to.ordermanagementservice.dto;

import com.to.ordermanagementservice.entity.OrderItem;

import java.time.OffsetDateTime;
import java.util.List;

public class OrderDetails {//todo reterne all list of order and user ()

    private Integer orderId;

    private Integer userId;// todo put castomer id not user

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private List<OrderItemDetails> orderItems;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<OrderItemDetails> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDetails> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
// todo are sent two repositorie (entity) transform and link entities to dto and on transfer layer
}
