package ru.job4j.srp.parsers.hr;

import ru.job4j.srp.Employee;
import ru.job4j.srp.parsers.Parse;

import java.util.List;

public class HrHtml implements Parse {
    @Override
    public String parse(List<Employee> list) {
        StringBuilder text = new StringBuilder();
        text.append("<! DOCTYPE html>").append(System.lineSeparator())
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("<h1>Name; Salary;</h1>").append(System.lineSeparator());
        list.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        for (Employee employee : list) {
            text.append("<p>")
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</p>").append(System.lineSeparator())
                    .append(System.lineSeparator())
                    .append("</body>").append(System.lineSeparator())
                    .append("</html");
        }
        return text.toString();
    }
}
