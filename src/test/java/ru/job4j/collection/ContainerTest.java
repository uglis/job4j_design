package ru.job4j.collection;


import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainerTest {
    @Test
    public void whenItHave3TrueAnd1False() {
        Container<Double> container = new Container<>();
        container.add(3D);
        container.add(5D);
        container.add(7D);
        Iterator<Double> it = container.iterator();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void when3IndexIs5() {
        Container<Integer> container = new Container<>();
        container.add(7);
        container.add(87);
        container.add(4);
        container.add(5);
        assertThat(container.get(3), is(5));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenEx() {
        Container<String> container = new Container<>();
        container.add("1");
        container.add("2");
        container.add("3");
        Iterator<String> it = container.iterator();
        container.add("5");
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoSuchEx() {
        Container<Float> container = new Container<>();
        Iterator<Float> it = container.iterator();
        it.next();
    }

    @Test
    public void whenGet2El() {
        Container<Integer> container = new Container<>();
        container.add(3);
        container.add(4);
        assertThat(container.get(0), is(3));
        assertThat(container.get(1), is(4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenUseItRemoveMethod() {
        Container<Integer> container = new Container<>();
        Iterator<Integer> it = container.iterator();
        it.remove();
    }
}