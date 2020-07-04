package ru.job4j.menu;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    private Menu menu = new Menu();

    @Test
    public void whenAdd2Items() {
        menu.addItem(new Item("1"));
        menu.addItem(new Item("2"));
        List<Item> expected = List.of(
                new Item("1"), new Item("2"));
        assertThat(menu.getMenu(), is(expected));
    }

    @Test
    public void whenAddSubItem() {
       Item parent = new Item("1");
       menu.addItem(parent);
       menu.addSubItem(parent, new Item("3"));
       assertThat(
               menu.getMenu().get(0).getSubItems().get(0),
               is(new Item("3")));
    }

    @Test
    public void whenRemoveItem() {
        Item item = new Item("1");
        menu.addItem(item);
        menu.removeItem(item);
        assertThat(menu.getMenu().size(), is(0));
    }

    @Test
    public void whenDoActionToItem() {
        Item item = new Item("item");
        PrintStream std = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(out);
        System.setOut(print);
        menu.addItem(item);
        menu.action(item);
        assertThat(out.toString(), is("do something to this - item" + System.lineSeparator()));
        System.setOut(std);
    }
}