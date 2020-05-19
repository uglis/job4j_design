package ru.job4j.io;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchFilesTest {
    @Test
    public void whenCheckPredicate() throws IOException {
        SearchFiles searchFiles = new SearchFiles((path -> path.toFile().getName().endsWith("class")));
        List<Path> expected = List.of(
                Path.of(".\\src\\data\\cl.class")
        );
        Path source = Paths.get(".\\src\\data");
        Files.walkFileTree(source, searchFiles);
        List<Path> rsl = searchFiles.getPaths();
        assertThat(rsl, is(expected));
    }
}