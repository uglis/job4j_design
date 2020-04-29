package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * 5.1.1. Итератор для двухмерного массива int[][][#279218]
 */
public class MatrixArrayIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixArrayIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (column == data.length - 1 && data[column].length > 0) {
            return row < data[column].length;
        }
        if (row == data[column].length) {
            row = 0;
            column++;
        }
        while (column < data.length - 1 && data[column].length == 0) {
            column++;
        }
        return column < data.length && row < data[column].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[column][row++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        throw new UnsupportedOperationException();
    }
}


