package ru.job4j.productstore;

import ru.job4j.productstore.products.Food;

import java.util.List;

public interface Storage {
    void add(Food food);

    boolean accept(Food food);

    List<Food> clear();
}
