package ru.job4j.menu;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    @Test
    public void whenHave4MenuItems() {
        Menu menu = new Menu();
        menu.add("2.1", new MenuItem("item4"));
        menu.add("1.1", new MenuItem("item2"));
        menu.add("2", new MenuItem("item3"));
        menu.add("1", new MenuItem("item1"));
        Map<String, MenuItem> expected = Map.of(
                "1", new MenuItem("item1"),
                "1.1", new MenuItem("item2"),
                "2", new MenuItem("item3"),
                "2.1", new MenuItem("item4")
        );
        assertThat(menu.getMenu(), is(expected));
    }

    @Test
    public void whenChoseMenuItem() {
        Menu menu = new Menu();
        menu.add("1.1", new MenuItem("item4"));
        menu.add("1", new MenuItem("item2"));
        MenuItem expected = menu.choosePoint("1");
        assertThat(expected, is(new MenuItem("item2")));
    }

    @Test
    public void whenShowMenu() {
        PrintStream stOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(out);
        System.setOut(print);
        Menu menu = new Menu();
        menu.add("1.1", new MenuItem("item2"));
        menu.add("2", new MenuItem("item3"));
        menu.add("1", new MenuItem("item1"));
        StringBuilder expected = new StringBuilder()
                .append("1 :").append(" item1;").append(System.lineSeparator())
                .append("-- 1.1 :").append(" item2;").append(System.lineSeparator())
                .append("2 :").append(" item3;").append(System.lineSeparator());
        menu.showMenu();
        assertThat(expected.toString(), is(out.toString()));
        System.setOut(stOut);
    }
}