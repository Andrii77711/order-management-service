package com.to;

import com.to.ordermanagementservice.entity.Book;
import com.to.ordermanagementservice.entity.Product;
import com.to.ordermanagementservice.enums.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final ProductWarehouseFacade productWarehouseStore;

    @Autowired
    public Main(ProductWarehouseFacade productWarehouseStore) {
        this.productWarehouseStore = productWarehouseStore;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        List<Product> invalidProducts = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Product book = new Book(i,
                    "m",
                    BigDecimal.valueOf(10),
                    "M",
                    1981,
                    146,
                    Genre.BIOGRAPHY);
            try {
                productWarehouseStore.addProduct(book);
            } catch (Exception e) {
                invalidProducts.add(book);
                System.out.println(e.getMessage());
            }
        }
        Product book = new Book(6,
                "f",
                BigDecimal.valueOf(40),
                "",
                1979,
                100,
                Genre.ROMANCE);
        try {
            productWarehouseStore.addProduct(book);
        } catch (Exception e) {
            invalidProducts.add(book);
            System.out.println(e.getMessage());
        }
        System.out.println("Product from store: ");
        productWarehouseStore.getProducts().forEach(product -> System.out.println(product.description()));
        System.out.println("invalidProducts: ");
        invalidProducts.forEach(product -> System.out.println(product.description()));
    }

}
