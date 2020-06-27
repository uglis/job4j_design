package ru.job4j.srp.parsers.accounts;

import ru.job4j.srp.Employee;
import ru.job4j.srp.parsers.Parse;

import java.util.List;

public class AccountsHtml implements Parse {
    @Override
    public String parse(List<Employee> list) {
        StringBuilder text = new StringBuilder();
        text.append("<! DOCTYPE html>").append(System.lineSeparator())
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("<h1>Name; Hired; Fired; Salary;</h1>").append(System.lineSeparator());
        for (Employee employee : list) {
            text.append("<p>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append((int) employee.getSalary()).append(";")
                    .append("</p>").append(System.lineSeparator())
                    .append(System.lineSeparator())
                    .append("</body>").append(System.lineSeparator())
                    .append("</html");
        }
        return text.toString();
    }
}
