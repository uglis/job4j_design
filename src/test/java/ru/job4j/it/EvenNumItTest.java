package ru.job4j.it;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EvenNumItTest {
    @Test
    public void whenHave2EvenNum() {
        int[] input = {3, 4, 7, 7, 4};
        EvenNumIt it = new EvenNumIt(input);
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(4));
    }

    @Test
    public void whenNext4EvenNum() {
        int[] input = {3, 3, 3, 4, 3, 6, 7, 8, 3, 2, 7, 7};
        EvenNumIt it = new EvenNumIt(input);
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenHasNext3Num() {
        int[] input = {3, 3, 2, 1, 3, 3, 4, 7, 8, 7, 9};
        EvenNumIt it = new EvenNumIt(input);
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(false));
    }
}
