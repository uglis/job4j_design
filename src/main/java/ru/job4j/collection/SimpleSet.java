package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

/**
 * 1. Реализовать коллекцию Set на массиве [#279228]
 */
public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> set = new SimpleArray<>();

    public void add(T value) {
        for (T t : set) {
            if (Objects.equals(t, value)) {
                return;
            }
        }
        set.add(value);
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
