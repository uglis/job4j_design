package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * 5.1.2. Создать итератор четные числа [#279215]
 */
public class EvenNumIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;
    private int countEvNum;

    public EvenNumIt(int[] data) {
        this.data = data;
        countEvNum = countEvenNum();
    }

    @Override
    public boolean hasNext() {
        if (countEvNum == 0) {
            return false;
        }
        catchEvenNum();
        return point++ < data.length;
    }

    @Override
    public Integer next() {
        if (countEvNum == 0) {
            throw new NoSuchElementException();
        }
        catchEvenNum();
        return data[point++];
    }

    /**
     * Находим текущее четное число.
     *
     * @return есть или нет.
     */
    private int countEvenNum() {
        int rsl = 0;
        for (int datum : data) {
            if (datum % 2 == 0) {
                rsl++;
            }
        }
        return rsl;
    }

    /**
     * Считаем кол-во четных чисел в массиве.
     */
    private void catchEvenNum() {
        for (int i = point; i < data.length; i++) {
            point = i;
            int a = data[i];
            if (data[i] % 2 == 0) {
                countEvNum--;
                break;
            }
        }
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
