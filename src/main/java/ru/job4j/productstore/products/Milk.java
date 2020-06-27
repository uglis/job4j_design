package ru.job4j.productstore.products;

import java.util.Date;

/**
 * Milk type.
 */
public class Milk extends Food {
    public Milk(String name, Date createDate, Date expiredDate, double price, int discount) {
        super(name, createDate, expiredDate, price, discount);
    }
}
