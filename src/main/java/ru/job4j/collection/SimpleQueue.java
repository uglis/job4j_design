package ru.job4j.collection;

import java.util.NoSuchElementException;

/**
 * 5. Очередь на двух стеках [#279210]
 *
 * @param <T>
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int countInQueue = 0;
    private int countOutQue = 0;

    public T poll() {
        if (countInQueue == 0) {
            throw new NoSuchElementException();
        }
        while (countOutQue < countInQueue) {
            out.push(in.pop());
            countOutQue++;
        }
        return out.pop();
    }

    public void push(T value) {
        countInQueue++;
        in.push(value);
    }
}
