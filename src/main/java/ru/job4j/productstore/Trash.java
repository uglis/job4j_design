package ru.job4j.productstore;

import ru.job4j.productstore.products.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Storage where products have percent is above 100.
 */
public class Trash {
    public static Trash instance;
    private List<Food> store = new ArrayList<>();

    private Trash() {

    }

    public static Trash getInstance() {
        if (instance == null) {
            instance = new Trash();
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
