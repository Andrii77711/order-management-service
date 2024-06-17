//1. write into class (change custimer (on userid)) replace orderitem id here
//2. setter metod and getter
//3. add userid here


package com.to.ordermanagementservice.entity;

import java.time.OffsetDateTime;

public class Order {

    private Integer id;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

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

    public void setCustomerId(int userId) {
    }
}
