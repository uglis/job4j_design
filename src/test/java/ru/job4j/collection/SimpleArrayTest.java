package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    @Test
    public void whenElMoreThanStartSize() {
        SimpleArray<Integer> input = new SimpleArray<>(5);
        input.add(4);
        input.add(7);
        input.add(2);
        input.add(7);
        input.add(8);
        input.add(2);
        input.add(5);
        input.add(8);
        assertThat(input.get(6), is(5));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCatchEx() {
        SimpleArray<Integer> input = new SimpleArray<>(5);
        input.add(5);
        input.add(2);
        input.add(7);
        input.add(6);
        for (Iterator<Integer> it = input.iterator(); it.hasNext();) {
            Integer i = it.next();
            input.add(10);
        }
    }
}