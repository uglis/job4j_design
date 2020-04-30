package ru.job4j.collection;

import java.util.*;

/**
 * 1. Динамический список на массиве. [#279208]
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int point = 0;
    private int modCount = 0;
    private int availableObj = 0;

    public SimpleArray(int size) {
        this.container = new Object[size];
    }

    public T get(int index) {
        Objects.checkIndex(index, point);
        return (T) this.container[index];
    }

    public void add(T model) {
        modCount++;
        if (point == container.length) {
            this.container = Arrays.copyOf(container, container.length * 2);
        }
        this.container[point++] = model;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final int expectedModCont = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCont != modCount) {
                    throw new ConcurrentModificationException();
                }
                return availableObj < point;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[availableObj++];
            }
        };
    }
}
