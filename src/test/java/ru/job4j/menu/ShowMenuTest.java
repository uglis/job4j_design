package ru.job4j.menu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShowMenuTest {
    private Menu menu = new Menu();
    private ShowMenu showMenu = new ShowMenu(menu);
    private PrintStream std = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void installOut() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void installOldOut() {
        System.setOut(std);
    }

    @Test
    public void whenShow1Item() {
        Item item = new Item("1");
        menu.addItem(item);
        showMenu.showMenu();
        assertThat(out.toString(), is("Task 1" + System.lineSeparator()));
    }

    @Test
    public void whenHave2ItemsAnd2SubItems() {
        Item item1 = new Item("1");
        Item item2 = new Item("2");
        menu.addItem(item1);
        menu.addItem(item2);
        Item subItem1 = new Item("1.1");
        Item subItem2 = new Item("2.1");
        menu.addSubItem(item1, subItem1);
        menu.addSubItem(item2, subItem2);
        StringJoiner expected = new StringJoiner(System.lineSeparator())
                .add("Task 1").add(" -Task 1.1")
                .add("Task 2").add(" -Task 2.1")
                .add("");
        showMenu.showMenu();
        assertThat(out.toString(), is(expected.toString()));
    }
}