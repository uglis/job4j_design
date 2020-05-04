package ru.job4j.collection;

import java.util.NoSuchElementException;

/**
 * 4. Используя контейнер на базе связанного списка создать контейнер Stack [#279207]
 */
public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        T t = linked.deleteLast();
        if (t == null) {
            throw new NoSuchElementException("Нет элементов в контейнере");
        }
        return t;
    }

    public void push(T value) {
        linked.add(value);
    }


}
