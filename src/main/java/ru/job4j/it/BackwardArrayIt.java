package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1. Что такое итератор.[#279217]
 */
public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;
    private int count;

    public BackwardArrayIt(int[] data) {
        this.data = data;
        this.count = data.length - 1;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[count--];
    }
}
