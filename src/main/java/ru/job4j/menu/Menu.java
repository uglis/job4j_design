package ru.job4j.menu;

import java.util.Map;
import java.util.TreeMap;

public class Menu implements IMenu {
    private Map<String, MenuItem> menu = new TreeMap<>();

    /**
     * Add point to menu.
     *
     * @param position position in menu.
     * @param item     menu item.
     */
    @Override
    public void add(String position, MenuItem item) {
        menu.put(position, item);
    }

    /**
     * Choose menu item and do something.
     *
     * @param position position in menu.
     */
    @Override
    public MenuItem choosePoint(String position) {
        System.out.printf("your chose = %s", menu.get(position).getName());
        return menu.get(position);
    }

    /**
     * Show all menu.
     */
    @Override
    public void showMenu() {
        for (Map.Entry<String, MenuItem> pair : menu.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue().getName();
            if (key.length() == 3) {
                System.out.println(String.format("-- %s : %s;", key, value));
            } else if (key.length() > 3) {
                System.out.println(String.format("--- %s : %s", key, value));
            } else {
                System.out.println(String.format("%s : %s;", key, value));
            }
        }
    }

    public Map<String, MenuItem> getMenu() {
        return menu;
    }
}
