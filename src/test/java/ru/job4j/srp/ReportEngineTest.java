package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.srp.parsers.ParseOldType;
import ru.job4j.srp.parsers.ParseStdHtml;
import ru.job4j.srp.parsers.accounts.AccountsHtml;
import ru.job4j.srp.parsers.accounts.AccountsJson;
import ru.job4j.srp.parsers.hr.HrJson;

import java.util.Calendar;
import java.util.StringJoiner;

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
        assertThat(engine.generate(em -> true, new ParseOldType()), is(expect.toString()));
    }

    @Test
    public void whenGetReportForProgrammers() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Igor", now, now, 200);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("<! DOCTYPE html>").append(System.lineSeparator())
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("<h1>Name; Hired; Fired; Salary;</h1>").append(System.lineSeparator())
                .append("<p>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</p>").append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html");
        assertThat(engine.generate(em -> true, new ParseStdHtml()), is(expected.toString()));
    }

    @Test
    public void whenGetJsonReportForAccountants() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Igor", now, now, 200.23);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringJoiner expect = new StringJoiner(System.lineSeparator());
        expect.add("{")
                .add(String.format("\"name\": \"%s\",", worker.getName()))
                .add(String.format("\"hired\": \"%s\",", worker.getHired()))
                .add(String.format("\"fired\": \"%s\",", worker.getFired()))
                .add(String.format("\"salary\": \"%s\"", (int) worker.getSalary()))
                .add("}");
        assertThat(engine.generate(em -> true, new AccountsJson()), is(expect.toString()));
    }

    @Test
    public void whenGetJsonReportForHr() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("user1", now, now, 200.23);
        Employee worker2 = new Employee("user2", now, now, 201.13);
        store.add(worker1);
        store.add(worker2);
        ReportEngine engine = new ReportEngine(store);
        StringJoiner expect = new StringJoiner(System.lineSeparator());
            expect.add("{")
                    .add(String.format("\"name\": \"%s\",", worker2.getName()))
                    .add(String.format("\"salary\": \"%s\"", worker2.getSalary()))
                    .add("}")
                    .add("{")
                    .add(String.format("\"name\": \"%s\",", worker1.getName()))
                    .add(String.format("\"salary\": \"%s\"", worker1.getSalary()))
                    .add("}");
        assertThat(engine.generate(em -> true, new HrJson()), is(expect.toString()));
    }
}