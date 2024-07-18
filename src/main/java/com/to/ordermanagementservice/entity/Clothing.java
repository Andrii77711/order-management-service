package com.to.ordermanagementservice.entity;

import java.math.BigDecimal;

public class Clothing extends Product {
    private int size;
    private String color;

    public Clothing(int id, String name, BigDecimal price, int size, String color) {
        super(id, name, price);
        this.size = size;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String description() {
        return "this " + getName() + " has size = " + getSize() + " and color " + getColor();
    }
}
