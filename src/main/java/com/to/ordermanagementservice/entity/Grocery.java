package com.to.ordermanagementservice.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Grocery extends Product{
    private OffsetDateTime expiryDate;

    public Grocery(int id, String name, BigDecimal price, OffsetDateTime expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    public OffsetDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(OffsetDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String description() {
        return "this " + getName() +  " will expire on " + getExpiryDate();
    }
}
