package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5. Очередь на двух стеках [#279210]
 *
 * @param <T>
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        try {
            while (true) {
                out.push(in.pop());
            }
        } catch (NoSuchElementException ignored) {
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}
