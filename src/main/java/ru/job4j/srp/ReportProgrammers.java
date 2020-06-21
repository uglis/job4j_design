package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportProgrammers implements Report {
    private Store store;

    public ReportProgrammers(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
