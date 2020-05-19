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
        Path source = Paths.get("C:\\test");
        List<Path> expected = List.of(
                Path.of("C:\\test\\Hello.java")
        );
        List<Path> rsl = Search.search(source, "java");
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSearchEndWithTxt() {
        Path source = Paths.get("C:\\test\\123\\search");
        List<Path> expected = List.of(
                Path.of("C:\\test\\123\\search\\54.txt"),
                Path.of("C:\\test\\123\\search\\64.txt")
        );
        List<Path> rsl = Search.search(source, "txt");
        assertThat(rsl, is(expected));
    }
}