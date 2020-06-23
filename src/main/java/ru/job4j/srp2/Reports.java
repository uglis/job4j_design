package ru.job4j.srp2;

import java.util.function.Predicate;

public interface Reports {
    String generateHtml(Predicate<Employee> filter);

    String generateJson(Predicate<Employee> filter);

    String generateXml(Predicate<Employee> filter);
}
