package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void addFiles() throws IOException {
        folder.newFile("test1.txt");
        folder.newFile("test2.txt");
        folder.newFile("test3.iml");
        folder.newFile("data.java");
    }

    @Test
    public void whenSearchEndWithJava() {
        Path source = Paths.get(folder.getRoot().toString());
        List<Path> expected = List.of(
                Path.of(folder.getRoot() + "/data.java"
                )
        );
        List<Path> rsl = Search.search(source, "java");
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSearchEndWithTxt() {
        Path source = Paths.get(folder.getRoot().toString());
        List<Path> expected = new ArrayList<>(
                List.of(
                        Path.of(folder.getRoot() + "/test1.txt"),
                        Path.of(folder.getRoot() + "/test2.txt")
                )
        );
        List<Path> rsl = Search.search(source, "txt");
        assertThat(rsl, is(expected));
    }
}