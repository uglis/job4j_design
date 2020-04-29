package ru.job4j.it;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EvenNumItTest {
    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new EvenNumIt(new int[] {1, 2, 3, 4, 5, 6, 7});
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }

    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenNumIt(new int[]{1});
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void allNumbersAreEven() {
        it = new EvenNumIt(new int[] {2, 4, 6, 8});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }
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
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNotEvenEl() {
        int[] input = {3, 3, 5, 7, 7, 9};
        EvenNumIt it = new EvenNumIt(input);
        it.next();
    }
}
