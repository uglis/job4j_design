package ru.job4j.productstore;

import ru.job4j.productstore.products.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Distribute foods to storage.
 */
public class ControlQuality {
    private Warehouse warehouse = Warehouse.getInstance();
    private Shop shop = Shop.getInstance();
    private Trash trash = Trash.getInstance();
    private List<Storage> storage = new ArrayList<>();

    public ControlQuality() {
        storage.add(warehouse);
        storage.add(shop);
        storage.add(trash);
    }

    /**
     * Add food to foods.
     *
     * @param food type of food.
     */
    public void distribute(Food food) {
        for (Storage st : storage) {
            if (st.accept(food)) {
                st.add(food);
                break;
            }
        }
    }
}
