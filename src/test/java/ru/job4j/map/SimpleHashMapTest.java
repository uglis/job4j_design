package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleHashMapTest {
    @Test
    public void whenPut3Pair() {
        SimpleHashMap<Integer, Double> map = new SimpleHashMap<>();
        map.insert(3, 56D);
        map.insert(4, 56D);
        map.insert(5, 56D);
        assertThat(map.get(5), is(56D));
    }

    @Test
    public void whenDeletePair() {
        SimpleHashMap<String, Double> map = new SimpleHashMap<>();
        map.insert("user1", 32D);
        map.delete("user1");
        assertThat(map.iterator().hasNext(), is(false));
    }

    @Test
    public void whenCheckIterator() {
        SimpleHashMap<Integer, Double> map = new SimpleHashMap<>();
        map.insert(3, 56D);
        map.insert(4, 56D);
        map.insert(5, 56D);
        Iterator<SimpleHashMap.Node<Integer, Double>> it = map.iterator();
        it.next();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenSizeIsRise() {
        SimpleHashMap<Integer, Integer> map = new SimpleHashMap<>();
        map.insert(1, 1);
        map.insert(2, 1);
        map.insert(3, 1);
        map.insert(4, 1);
        map.insert(5, 1);
        map.insert(6, 1);
        map.insert(7, 1);
        map.insert(8, 1);
        map.insert(9, 1);
        map.insert(10, 1);
        map.insert(11, 1);
        map.insert(12, 1);
        map.insert(13, 1);
        map.insert(14, 1);
        map.insert(15, 1);
        map.insert(16, 1);
        map.insert(17, 1);
        assertThat(map.get(17), is(1));
    }
}