package ru.job4j.menu;

import java.util.*;

/**
 * Create Menu. [#279292].
 */
public class ShowMenu implements IShowMenu {
    private Menu menu;

    public ShowMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * Show menu.
     */
    @Override
    public void showMenu() {
        List<Item> items = menu.getMenu();
        LinkedList<Item> date = new LinkedList<>();
        for (Item it : items) {
            date.offer(it);
            while (!date.isEmpty()) {
                Item item = date.poll();
                showEachItem(item);
                date.addAll(item.getSubItems());
                date.sort(Comparator.comparing(Item::getName));
            }
        }
    }

    /**
     * Each element is printed depending on the type.
     *
     * @param item item.
     */
    private void showEachItem(Item item) {
        if (item.getName().length() < 2) {
            System.out.println(String.format("Task %s", item.getName()));
        } else if (item.getName().length() < 4) {
            System.out.println(String.format(" -Task %s", item.getName()));
        } else {
            System.out.println(String.format(" --Task %s", item.getName()));
        }
    }
}
