package com.to.ordermanagementservice.entity;

import com.to.ordermanagementservice.enums.Genre;

import java.math.BigDecimal;

public class Book extends Product {
    private String author;
    private int year;
    private int pages;
    private Genre genre;

    public Book(int id, String name, BigDecimal price, String author, int year, int pages, Genre genre) {
        super(id, name, price);
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String description() {
        return "This " + getName() + " created by " + getAuthor() + " in " + getYear()
                + ". This book has genre " + getGenre() + " and pages " + getPages();
    }
}
