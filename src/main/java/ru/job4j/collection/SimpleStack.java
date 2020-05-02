package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 4. Используя контейнер на базе связанного списка создать контейнер Stack [#279207]
 */
public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        T t = findLast();
        if (t == null) {
            throw new NoSuchElementException("Нет элементов в контейнере");
        }
        deleteLast();
        return t;
    }

    public void push(T value) {
        linked.add(value);
    }

    /**
     * Удаляем последний объект из списка.
     */
    public void deleteLast() {
        ForwardLinked<T> temp = new ForwardLinked<>();
        T t = findLast();
        if (t == null) {
            return;
        }
        Iterator<T> iterator = linked.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (element != t) {
                temp.add(element);
            }
        }
        linked = temp;
    }

    /**
     * Находим последний объект.
     *
     * @return последний объект.
     */
    public T findLast() {
        Iterator<T> it = linked.iterator();
        T t = null;
        while (it.hasNext()) {
            t = it.next();
        }
        return t;
    }
}
