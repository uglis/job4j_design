package ru.job4j.srp2.departaments;

import ru.job4j.srp2.Employee;
import ru.job4j.srp2.Reports;
import ru.job4j.srp2.Store;

import java.util.List;
import java.util.function.Predicate;

public class HrReport implements Reports {
    private Store store;

    public HrReport(Store store) {
        this.store = store;
    }

    @Override
    public String generateHtml(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<! DOCTYPE html>").append(System.lineSeparator())
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("<h1>Name; Salary;</h1>").append(System.lineSeparator());
        List<Employee> employees = store.findBy(filter);
        employees.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        for (Employee employee : employees) {
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

    @Override
    public String generateJson(Predicate<Employee> filter) {
        StringBuilder sb = new StringBuilder();
        List<Employee> employees = store.findBy(filter);
        employees.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        for (Employee employee : employees) {
            sb.append("{").append(System.lineSeparator())
                    .append(String.format("\"name\": \"%s\",", employee.getName())).append(System.lineSeparator())
                    .append(String.format("\"salary\": \"%s\"", employee.getSalary())).append(System.lineSeparator())
                    .append("}").append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String generateXml(Predicate<Employee> filter) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(System.lineSeparator());
        sb.append("<employees>").append(System.lineSeparator());
        List<Employee> employees = store.findBy(filter);
        employees.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        for (Employee employee : employees) {
            sb.append("<employee>").append(System.lineSeparator())
                    .append(String.format("<name>%s</name>", employee.getName())).append(System.lineSeparator())
                    .append(String.format("<salary>%s</salary>", employee.getSalary())).append(System.lineSeparator());
        }
        sb.append("</employee>").append(System.lineSeparator());
        return sb.toString();
    }
}
