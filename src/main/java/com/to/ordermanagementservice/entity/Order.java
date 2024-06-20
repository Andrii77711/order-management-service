//1.todo write into class (change custimer (on userid)) replace orderitem id here
//2.todo setter metod and getter
//3.todo add userid here


package com.to.ordermanagementservice.entity;

import java.time.OffsetDateTime;
import java.util.List;

public class Order {

    private Integer id;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private List<OrderItem> orderItems;

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


}
