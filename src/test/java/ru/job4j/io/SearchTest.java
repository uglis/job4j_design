package ru.job4j.io;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchTest {
    @Test
    public void whenSearchEndWithJava() {
        Path source = Paths.get(".\\src\\data");
        List<Path> expected = List.of(
                Path.of(".\\src\\data\\test.java")
        );
        List<Path> rsl = Search.search(source, "java");
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSearchEndWithTxt() {
        Path source = Paths.get(".\\src\\data");
        List<Path> expected = List.of(
                Path.of(".\\src\\data\\server.txt"),
                Path.of(".\\src\\data\\server1.txt"),
                Path.of(".\\src\\data\\target.txt"),
                Path.of(".\\src\\data\\target1.txt")
        );
        List<Path> rsl = Search.search(source, "txt");
        assertThat(rsl, is(expected));
    }
}