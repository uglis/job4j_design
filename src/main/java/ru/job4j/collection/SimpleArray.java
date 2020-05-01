package ru.job4j.collection;

import java.util.*;
import java.util.function.Consumer;

/**
 * 1. Динамический список на массиве. [#279208]
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int point = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.container = new Object[0];
    }

    public T get(int index) {
        Objects.checkIndex(index, point);
        return (T) this.container[index];
    }

    public void add(T model) {
        modCount++;
        if (point == container.length) {
            this.container = Arrays.copyOf(container, container.length + 1);
        }
        this.container[point++] = model;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final int expectedModCont = modCount;
            int itCount = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCont != modCount) {
                    throw new ConcurrentModificationException();
                }
                return itCount < point;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[itCount++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void forEachRemaining(Consumer<? super T> action) {
                throw new UnsupportedOperationException();
            }
        };
    }
}
