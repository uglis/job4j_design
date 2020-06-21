package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 1. Принципы Kiss, Dry и Yagni [#279273]
 */
public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = integer -> integer < 0;
        return condition(value, comparator, predicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = integer -> integer > 0;
        return condition(value, comparator, predicate);
    }

    private  <T> T condition(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T t = value.get(0);
        for (T val : value) {
            int temp = comparator.compare(t, val);
            t = predicate.test(temp) ? val : t;
        }
        return t;
    }
}
