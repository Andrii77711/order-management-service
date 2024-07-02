package com.to.ordermanagementservice.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class OrderDetails {

    private Integer id;

    private Integer customerId;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private List<OrderItemDetails> orderItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

}
