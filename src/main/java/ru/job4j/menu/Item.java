package ru.job4j.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Data model "Item".
 */
public class Item {
    private String name;
    private List<Item> subItems = new ArrayList<>();

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getSubItems() {
        return subItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Item{"
                + "name='" + name + '\''
                + '}';
    }
}
