package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * 1. Отчеты. [#279282]
 */
public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);
}
