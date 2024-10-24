package com.to.ordermanagementservice.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Grocery extends Product {
    private LocalDate expiryDate;

    public Grocery(int id, String name, BigDecimal price, LocalDate expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String description() {
        return "this " + getName() +  " will expire on " + getExpiryDate();
    }
}
