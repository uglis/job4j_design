package ru.job4j.productstore;

import ru.job4j.productstore.products.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Storage where products have percent is above 100.
 */
public class Trash implements Storage, CheckBalancePercent {
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

    @Override
    public boolean accept(Food food) {
        int percent = checkBalancePercent(food.getCreateDate(), food.getExpiredDate());
        return percent > 100;
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
