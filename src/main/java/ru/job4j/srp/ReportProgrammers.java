package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportProgrammers implements Report {
    private Store store;

    public ReportProgrammers(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<! DOCTYPE html>").append(System.lineSeparator())
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("h1>Name; Hired; Fired; Salary;</h1>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<p>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</p>").append(System.lineSeparator())
                    .append(System.lineSeparator())
                    .append("</body>").append(System.lineSeparator())
                    .append("</html");
        }
        return text.toString();
    }
}
