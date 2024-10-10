package com.to.ordermanagementservice.dto;

import java.time.OffsetDateTime;

public class OrderItemDetails {

    private Integer orderId;

    private ProductDetails product;

    private Integer id;

    private Integer quantity;

    private OffsetDateTime updatedAt;

    private OffsetDateTime createdAt;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public ProductDetails getProduct() {
        return product;
    }

    public void setProduct(ProductDetails product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

