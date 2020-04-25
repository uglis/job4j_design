package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * 5.1.1. Итератор для двухмерного массива int[][][#279218]
 */
public class MatrixArrayIt implements Iterator<Integer> {
    private final int[][] data;
    private int count;
    private int pointX = 0;
    private int pointY = 0;

    public MatrixArrayIt(int[][] data) {
        this.data = data;
        count = checkPoint();
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        if (count == 0) {
            throw new NoSuchElementException();
        }
        if (count > 0) {
            rsl = true;
            count--;
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (count == 0) {
            throw new NoSuchElementException();
        }
        int currentMassive = checkMassiveLength(data, pointX);
        if (currentMassive == pointY) {
            pointX++;
            pointY = 0;
        }
        count--;
        return data[pointX][pointY++];
    }

    /**
     * Считаем кол-во элементнов в data.
     *
     * @return кол-во элементов.
     */
    private int checkPoint() {
        int count = 0;
        for (int[] datum : data) {
            for (int ignored : datum) {
                count++;
            }
        }
        return count;
    }

    /**
     * Находим длину текущего массива.
     *
     * @param massive data.
     * @param row     ряд.
     * @return длина массива.
     */
    private int checkMassiveLength(int[][] massive, int row) {
        return massive[row].length;
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
