package ru.job4j.srp.parsers.hr;

import ru.job4j.srp.Employee;
import ru.job4j.srp.parsers.Parse;

import java.util.List;
import java.util.StringJoiner;

public class HrJson implements Parse {
    @Override
    public String parse(List<Employee> list) {
        StringJoiner sb = new StringJoiner(System.lineSeparator());
        list.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        for (Employee employee : list) {
            sb.add("{")
                    .add(String.format("\"name\": \"%s\",", employee.getName()))
                    .add(String.format("\"salary\": \"%s\"", employee.getSalary()))
                    .add("}");
        }
        return sb.toString();
    }
}
