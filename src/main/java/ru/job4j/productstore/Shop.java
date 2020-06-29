package ru.job4j.productstore;

import ru.job4j.productstore.products.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Storage where products have percent between 25 and 75.
 */
public class Shop implements Storage, CheckBalancePercent {
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

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        int percent = checkBalancePercent(food.getCreateDate(), food.getExpiredDate());
        if (percent >= 25 && percent < 75) {
            rsl = true;
        } else if (percent >= 75 && percent < 100) {
            food.setDiscount(10);
            rsl = true;
        }
        return rsl;
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
