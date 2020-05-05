package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    @Test
    public void whenAddDuplicate() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(9);
        set.add(9);
        Iterator<Integer> it = set.iterator();
        it.next();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenAdd3Duplicate() {
        SimpleSet<Double> set = new SimpleSet<>();
        set.add(9D);
        set.add(91D);
        set.add(91D);
        set.add(91D);
        set.add(10D);
        Iterator<Double> it = set.iterator();
        it.next();
        it.next();
        assertThat(it.next(), is(10D));
    }

    @Test
    public void whenCheckIterator() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("obj1");
        set.add("obj2");
        set.add("obj2");
        set.add("obj1");
        set.add("obj3");
        set.add("obj4");
        set.add("obj5");
        set.add("obj5");
        set.add("obj1");
        Iterator<String> it = set.iterator();
        assertThat(it.next(), is("obj1"));
        assertThat(it.next(), is("obj2"));
        assertThat(it.next(), is("obj3"));
        assertThat(it.next(), is("obj4"));
        assertThat(it.next(), is("obj5"));
        assertThat(it.hasNext(), is(false));
    }
}