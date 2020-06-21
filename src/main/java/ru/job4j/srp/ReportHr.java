package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportHr implements Report {
    private Store store;

    public ReportHr(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        List<Employee> list = store.findBy(filter);
        //noinspection CheckStyle
        list.sort((o1, o2) -> Double.compare (o2.getSalary(), o1.getSalary()));
        for (Employee employee : list) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}
