package com.to.ordermanagementservice.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Electronic extends Product {
    private String brand;
    private OffsetDateTime warrantyPeriod;

    public Electronic(int id, String name, BigDecimal price, String brand, OffsetDateTime warrantyPeriod) {
        super(id, name, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public OffsetDateTime getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(OffsetDateTime warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String description() {
        return "this " + getName() + " " + getBrand() + " will expire warranty period on " + getWarrantyPeriod();
    }
}
