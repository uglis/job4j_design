package ru.job4j.productstore;

import ru.job4j.productstore.products.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Storage where products have percent between 25 and 75.
 */
public class Shop {
    private static Shop instance;
    private List<Food> store = new ArrayList<>();

    private Shop() {
    }

    public static Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    public void add(Food food) {
        store.add(food);
    }

    public List<Food> getStore() {
        return store;
    }
}
