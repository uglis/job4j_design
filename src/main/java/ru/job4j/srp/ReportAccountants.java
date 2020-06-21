package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportAccountants implements Report {
    private Store store;

    public ReportAccountants(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append((int) employee.getSalary()).append(";");
        }
        return text.toString();
    }
}
