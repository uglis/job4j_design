package ru.job4j.productstore;

import ru.job4j.productstore.products.Food;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class ControlQuality {
    private Warehouse warehouse = Warehouse.getInstance();
    private Shop shop = Shop.getInstance();
    private Trash trash = Trash.getInstance();
    private List<Food> foods = new ArrayList<>();

    /**
     * When we create instance of this, we add all values of Warehouse and Shop to foods.
     */
    public ControlQuality() {
        foods.addAll(warehouse.getStore());
        foods.addAll(shop.getStore());
        warehouse.getStore().clear();
        shop.getStore().clear();
    }

    /**
     * Add food to foods.
     *
     * @param food type of food.
     */
    public void add(Food food) {
        foods.add(food);
    }

    /**
     * Checking and rewriting all the products from the all storage.
     */
    public void checkProducts() {
        for (Food food : foods) {
            int percent = checkBalancePercent(food.getCreateDate(), food.getExpiredDate());
            if (percent < 25) {
                warehouse.add(food);
            } else if (percent >= 25 && percent < 75) {
                shop.add(food);
            } else if (percent >= 75 && percent < 100) {
                food.setDiscount(10);
                shop.add(food);
            } else {
                trash.add(food);
            }
        }
    }

    /**
     * Checking how much percent was used to expired date.
     *
     * @param create create date.
     * @param exp    expire date.
     * @return percent.
     */
    private int checkBalancePercent(Date create, Date exp) {
        int totalTimeExp = daysBetween(create, exp);
        int totalPastTime = daysBetween(create, new Date(System.currentTimeMillis()));
        return (totalPastTime * 100) / totalTimeExp;
    }

    /**
     * Calculating days between two dates.
     *
     * @param d1 first date.
     * @param d2 second date.
     * @return days.
     */
    private int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
