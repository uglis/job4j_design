package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReportEngineTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGetReportForProgrammers() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Igor", now, now, 200);
        store.add(worker);
        ReportProgrammers engine = new ReportProgrammers(store);
        StringBuilder expected = new StringBuilder()
                .append("<! DOCTYPE html>").append(System.lineSeparator())
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("h1>Name; Hired; Fired; Salary;</h1>").append(System.lineSeparator())
                .append("<p>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</p>").append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html");
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }

    @Test
    public void whenGetReportForAccountants() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Igor", now, now, 200.23);
        store.add(worker);
        ReportAccountants engine = new ReportAccountants(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append((int) worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGetReportForHr() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("user1", now, now, 200.23);
        Employee worker2 = new Employee("user2", now, now, 201.13);
        store.add(worker1);
        store.add(worker2);
        ReportHr engine = new ReportHr(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}