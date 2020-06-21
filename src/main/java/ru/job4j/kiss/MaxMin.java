package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 1. Принципы Kiss, Dry и Yagni [#279273]
 */
public class MaxMin {
    /**
     * Find maximal value from list.
     *
     * @param value      list.
     * @param comparator comparator.
     * @param <T>        value.
     * @return max value.
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return condition(value, comparator, i -> i < 0);
    }

    /**
     * Find minimal value from list.
     *
     * @param value      list.
     * @param comparator comparator.
     * @param <T>        value.
     * @return min value.
     */
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return condition(value, comparator, i -> i > 0);
    }

    /**
     * Find value from list with condition.
     *
     * @param value      list.
     * @param comparator comparator.
     * @param <T>        value.
     * @return value.
     */
    private <T> T condition(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T t = value.get(0);
        for (T val : value) {
            int temp = comparator.compare(t, val);
            t = predicate.test(temp) ? val : t;
        }
        return t;
    }
}
