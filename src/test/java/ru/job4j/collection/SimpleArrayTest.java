package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
        Iterator<Integer> it = input.iterator();
        input.add(5);
        it.next();
    }

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>(3);
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<>(3);
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArray<String> array = new SimpleArray<>(3);
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArray<String> array = new SimpleArray<>(3);
        array.add("first");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleArray<String> array = new SimpleArray<>(0);
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleArray<String> array = new SimpleArray<>(3);
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }
}