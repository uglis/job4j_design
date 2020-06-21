package ru.job4j.kiss;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MaxMinTest {
    @Test
    public void whenMax() {
        List<Integer> input = List.of(1, 3, 5);
        MaxMin maxMin = new MaxMin();
        int result = maxMin.max(input, Integer::compareTo);
        assertThat(result, is(5));
    }

    @Test
    public void whenMin() {
        List<Integer> input = List.of(1, 3, 5);
        MaxMin maxMin = new MaxMin();
        int result = maxMin.min(input, Integer::compareTo);
        assertThat(result, is(1));
    }

    @Test
    public void whenHaveMinString() {
        List<String> input = List.of("one", "tho", "four");
        MaxMin maxMin = new MaxMin();
        String  result = maxMin.min(input, String::compareTo);
        assertThat(result, is("four"));
    }
}