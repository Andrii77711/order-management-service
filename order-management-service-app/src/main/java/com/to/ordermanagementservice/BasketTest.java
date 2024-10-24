package com.to.ordermanagementservice;

import com.to.ordermanagementservice.entity.Book;
import com.to.ordermanagementservice.entity.Clothing;
import com.to.ordermanagementservice.entity.Electronic;
import com.to.ordermanagementservice.entity.Grocery;
import com.to.ordermanagementservice.enums.Genre;
import com.to.ordermanagementservice.repository.BasketRepository;
import com.to.ordermanagementservice.repository.impl.BasketRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BasketTest {
    public static void main(String[] args) {
        BasketRepository basket = new BasketRepositoryImpl();
        Electronic electronic1 = new Electronic(1,
                "TV",
                new BigDecimal(50000),
                "SAMSUNG",
                LocalDate.now());
        basket.addProduct(electronic1);
        Electronic electronic2 = new Electronic(2,
                "PS",
                new BigDecimal(25000),
                "SONY",
                LocalDate.now());
        basket.addProduct(electronic2);
        Electronic electronic3 = new Electronic(3,
                "Phone",
                new BigDecimal(300),
                "Nokia",
                LocalDate.now());
        basket.addProduct(electronic3);
        Grocery grocery1 = new Grocery(4,
                "bread",
                new BigDecimal(23),
                LocalDate.now());
        basket.addProduct(grocery1);
        Grocery grocery2 = new Grocery(5,
                "milk",
                new BigDecimal(42),
                LocalDate.now());
        basket.addProduct(grocery2);
        Grocery grocery3 = new Grocery(6,
                "meat",
                new BigDecimal(150),
                LocalDate.now());
        basket.addProduct(grocery3);
        Clothing clothing1 = new Clothing(7,
                "ClubTS",
                new BigDecimal(20),
                50,
                "Blue");
        basket.addProduct(clothing1);
        Clothing clothing2 = new Clothing(8,
                "Pants",
                new BigDecimal(40),
                48,
                "yellow");
        basket.addProduct(clothing2);
        Book book1 = new Book(9,
                "Divine comedy",
                new BigDecimal("1.80"),
                "Dante Alegrei",
                1680,
                238,
                Genre.MYSTERY);
        basket.addProduct(book1);
        Book book2 = new Book(10,
                "Kobzar",
                new BigDecimal("2.80"),
                "Tarass Shevchenko",
                1820,
                1000000,
                Genre.ROMANCE);
        basket.addProduct(book2);
        basket.getDescriptionsForAllProducts().forEach(System.out::println);
    }
}
