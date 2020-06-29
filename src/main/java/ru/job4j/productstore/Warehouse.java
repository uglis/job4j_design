package ru.job4j.productstore;

import ru.job4j.productstore.products.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Storage where products have percent less 25.
 */
public class Warehouse implements Storage, CheckBalancePercent {
    private static Warehouse instance;
    private List<Food> store = new ArrayList<>();

    private Warehouse() {

    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void add(Food food) {
        store.add(food);
    }

    @Override
    public boolean accept(Food food) {
        int percent = checkBalancePercent(food.getCreateDate(), food.getExpiredDate());
        return percent < 25;
    }

    @Override
    public List<Food> clear() {
        List<Food> foods = new ArrayList<>(store);
        store.clear();
        return foods;
    }

    public List<Food> getStore() {
        return store;
    }
}
