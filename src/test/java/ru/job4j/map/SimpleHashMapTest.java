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

    @Test
    public void whenInsertStrings() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("Hello", 1);
        map.insert("Good morning", 2);
        map.insert("Good afternoon", 3);
        map.insert("A", 4);
        map.insert("H", 5);
        map.insert("KK", 6);
        map.insert("AAr", 3);
        map.insert("FFF", 3);
        map.insert("423423", 5);
        map.insert("www.mail.ru", 43);
        map.insert("google.com", 43);
        assertThat(map.get("Hello"), is(1));
    }

    @Test
    public void whenInsertUsers() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(new User("1", 3, "12.12.125"), 34);
        map.insert(new User("1", 3, "12.12.125"), 53);
        map.insert(new User("5", 1, "12.11.12868"), 12);
        map.insert(new User("2", 3, "02.12.1223"), 7);
        map.insert(new User("3", 4, "12.11.12454"), 1);
        map.insert(new User("6", 3, "022.10.1255"), 7);
        map.insert(new User("5", 1, "12.11.12868"), 12);
        map.insert(new User("9", 67, "07.12.12234"), 1);
        map.insert(new User("10", 468, "12.12.122423"), 1);
        map.insert(new User("6", 3, "022.10.1255"), 7);
        map.insert(new User("1", 3, "12.12.125"), 3);
        assertThat(map.get(new User("1", 3, "12.12.125")), is(3));
    }

    @Test
    public void whenGetSize() {
        SimpleHashMap<Integer, Integer> map = new SimpleHashMap<>();
        map.insert(1, 1);
        map.insert(2, 2);
        map.insert(3, 3);
        assertThat(map.size(), is(3));
    }
}