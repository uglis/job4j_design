package ru.job4j.menu;

import java.util.*;
import java.util.function.Predicate;

/**
 * Create Menu. [#279292].
 */
public class Menu implements IMenu<Item> {
    private List<Item> menu = new ArrayList<>();

    public List<Item> getMenu() {
        return menu;
    }

    /**
     * Add item to menu.
     *
     * @param value new item.
     */
    @Override
    public void addItem(Item value) {
        menu.add(value);
        menu.sort(Comparator.comparing(Item::getName));
    }

    /**
     * Add subItem.
     *
     * @param parent parent item.
     * @param subItem  new subItem.
     */
    @Override
    public void addSubItem(Item parent, Item subItem) {
        Item item = getItem(parent);
        if (item != null) {
            item.getSubItems().add(subItem);
        }
    }

    /**
     * Find item.
     *
     * @param value item.
     * @return found or not.
     */
    @Override
    public Item getItem(Item value) {
        return findByPredicate(item -> item.equals(value));
    }

    /**
     * Remove item.
     *
     * @param value item.
     * @return removed or not.
     */
    @Override
    public boolean removeItem(Item value) {
        boolean rsl;
        if (menu.contains(value)) {
            menu.remove(value);
            rsl = true;
        } else {
            rsl = removeSubItem(value);
        }
        return rsl;
    }

    /**
     * Remove subItem.
     *
     * @param value subItem.
     * @return removed or not.
     */
    private boolean removeSubItem(Item value) {
        Item rsl = findByPredicate(item -> item.getSubItems().contains(value));
        if (rsl != null) {
            rsl.getSubItems().remove(value);
            return true;
        }
        return false;
    }

    /**
     * Action to item.
     *
     * @param value item.
     */
    @Override
    public void action(Item value) {
        System.out.println(String.format("do something to this - %s", value.getName()));
    }

    /**
     * Find item by predicate.
     *
     * @param predicate predicate.
     * @return found item.
     */
    private Item findByPredicate(Predicate<Item> predicate) {
        Item item = null;
        Queue<Item> data = new LinkedList<>();
        for (Item itm : menu) {
            data.offer(itm);
            while (!data.isEmpty()) {
                Item rsl = data.poll();
                if (predicate.test(rsl)) {
                    item = rsl;
                    break;
                }
            }
            data.addAll(itm.getSubItems());
            if (item != null) {
                break;
            }
        }
        return item;
    }
}
