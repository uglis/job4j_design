package ru.job4j.srp;

import ru.job4j.srp.parsers.Parse;

import java.util.function.Predicate;

/**
 * 1. Отчеты. [#279282]
 */
public class ReportEngine implements Report {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter, Parse parser) {
        return parser.parse(store.findBy(filter));
    }
}
