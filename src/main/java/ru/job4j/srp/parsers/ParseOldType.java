package ru.job4j.srp.parsers;

import ru.job4j.srp.Employee;

import java.util.List;

public class ParseOldType implements Parse {
    @Override
    public String parse(List<Employee> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("Name; Hired; Fired; Salary;");
        for (Employee employee : list) {
            sb.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return sb.toString();
    }
}
