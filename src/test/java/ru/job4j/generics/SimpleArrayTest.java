package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    @Test
    public void thenAdd3IntegerEl() {
        SimpleArray<Integer> input = new SimpleArray<>(5);
        input.add(4);
        input.add(10);
        input.add(5);
        assertThat(input.get(0), is(4));
        assertThat(input.get(1), is(10));
        assertThat(input.get(2), is(5));
    }

    @Test
    public void thenGet3StringEl() {
        SimpleArray<String> input = new SimpleArray<>(5);
        input.add("str1");
        input.add("str2");
        input.add("str3");
        input.add("str4");
        input.add("str5");
        assertThat(input.get(4), is("str5"));
        assertThat(input.get(0), is("str1"));
        assertThat(input.get(3), is("str4"));
    }

    @Test
    public void whenIterateEl() {
        SimpleArray<Character> input = new SimpleArray<>(5);
        input.add('a');
        input.add('b');
        input.add('c');
        input.add('d');
        input.add('e');
        assertThat(input.hasNext(), is(true));
        assertThat(input.next(), is('a'));
        assertThat(input.hasNext(), is(true));
        assertThat(input.next(), is('b'));
        assertThat(input.hasNext(), is(true));
        assertThat(input.next(), is('c'));
        assertThat(input.hasNext(), is(true));
        assertThat(input.next(), is('d'));
        assertThat(input.hasNext(), is(true));
        assertThat(input.next(), is('e'));
        assertThat(input.hasNext(), is(false));
    }

    @Test
    public void whenSetEl() {
        SimpleArray<Double> input = new SimpleArray<>(3);
        input.add(10D);
        input.add(12D);
        input.add(14D);
        input.set(2, 23D);
        assertThat(input.get(2), is(23D));
    }

    @Test
    public void whenDeleteEl() {
        SimpleArray<Float> input = new SimpleArray<>(3);
        input.add(12F);
        input.add(15F);
        input.add(17F);
        input.remove(1);
        assertThat(input.get(1), is(17F));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenDeleteLastEl() {
        SimpleArray<Integer> input = new SimpleArray<>(3);
        input.add(3);
        input.add(4);
        input.add(5);
        input.remove(2);
        assertNull(input.get(2));
    }
}
