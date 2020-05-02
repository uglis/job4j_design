package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.1.2. Создать итератор четные числа [#279215]
 */
public class EvenNumIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenNumIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean found = false;
        for (int i = point; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                point = i;
                found = true;
                break;
            }
        }
        return found;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
