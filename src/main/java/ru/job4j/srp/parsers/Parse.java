package ru.job4j.srp.parsers;

import ru.job4j.srp.Employee;

import java.util.List;

public interface Parse {
    String parse(List<Employee> list);
}
