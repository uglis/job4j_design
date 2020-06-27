package ru.job4j.productstore.products;

import java.util.Date;

/**
 * Meat type.
 */
public class Meat extends Food {
    public Meat(String name, Date createDate, Date expiredDate, double price, int discount) {
        super(name, createDate, expiredDate, price, discount);
    }
}
