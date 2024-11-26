package com.to;

import com.to.exception.CapacityValidationException;
import com.to.exception.ProductValidationException;
import com.to.ordermanagementservice.entity.Book;
import com.to.ordermanagementservice.entity.Clothing;
import com.to.ordermanagementservice.entity.Electronic;
import com.to.ordermanagementservice.entity.Grocery;
import com.to.ordermanagementservice.entity.Product;
import com.to.ordermanagementservice.enums.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
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
        addBook(invalidProducts);
        addGrocery(invalidProducts);
        addClothing(invalidProducts);
        addElectronic(invalidProducts);
        System.out.println("Product from store: ");
        productWarehouseStore.getProducts().forEach(product -> System.out.println(product.description()));
        System.out.println("invalidProducts: ");
        invalidProducts.forEach(product -> System.out.println(product.description()));
    }

    private void addBook(List<Product> invalidProducts) {
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
            } catch (ProductValidationException e) {
                invalidProducts.add(book);
                System.out.println(e.getMessage());
            } catch (CapacityValidationException e) {
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
        } catch (ProductValidationException e) {
            invalidProducts.add(book);
            System.out.println(e.getMessage());
        } catch (CapacityValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addGrocery(List<Product> invalidProducts) {
        for (int i = 0; i < 6; i++) {
            Product grocery = new Grocery(i,
                    "m",
                    BigDecimal.valueOf(10),
                    LocalDate.now());
            try {
                productWarehouseStore.addProduct(grocery);
            } catch (ProductValidationException e) {
                invalidProducts.add(grocery);
                System.out.println(e.getMessage());
            } catch (CapacityValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addClothing(List<Product> invalidProducts) {
        for (int i = 0; i < 6; i++) {
            Product clothing = new Clothing(i,
                    "m",
                    BigDecimal.valueOf(10),
                    12,
                    "12");
            try {
                productWarehouseStore.addProduct(clothing);
            } catch (ProductValidationException e) {
                invalidProducts.add(clothing);
                System.out.println(e.getMessage());
            } catch (CapacityValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addElectronic(List<Product> invalidProducts) {
        for (int i = 0; i < 6; i++) {
            Product electronic = new Electronic(i,
                    "m",
                    BigDecimal.valueOf(10),
                    "k",
                    LocalDate.now());
            try {
                productWarehouseStore.addProduct(electronic);
            } catch (ProductValidationException e) {
                invalidProducts.add(electronic);
                System.out.println(e.getMessage());
            } catch (CapacityValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
