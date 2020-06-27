package ru.job4j.productstore.products;

import java.util.Date;

/**
 * Juice type.
 */
public class Juice extends Food {
    public Juice(String name, Date createDate, Date expiredDate, double price, int discount) {
        super(name, createDate, expiredDate, price, discount);
    }
}
