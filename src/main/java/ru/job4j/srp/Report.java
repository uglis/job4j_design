package ru.job4j.srp;

import ru.job4j.srp.parsers.Parse;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter, Parse parse);
}
