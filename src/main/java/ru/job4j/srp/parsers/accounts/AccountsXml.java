package ru.job4j.srp.parsers.accounts;

import ru.job4j.srp.Employee;
import ru.job4j.srp.parsers.Parse;

import java.util.List;
import java.util.StringJoiner;

public class AccountsXml implements Parse {
    @Override
    public String parse(List<Employee> list) {
        StringJoiner sb = new StringJoiner(System.lineSeparator());
        sb.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .add("<employees>");
        for (Employee employee : list) {
            sb.add("<employee>")
                    .add(String.format("<name>%s</name>", employee.getName()))
                    .add(String.format("<hired>%s</hired>", employee.getHired()))
                    .add(String.format("<fired>%s</fired>", employee.getFired()))
                    .add(String.format("<salary>%s</salary>", (int) employee.getSalary()));
        }
        sb.add("</employee>");
        return sb.toString();
    }
}
