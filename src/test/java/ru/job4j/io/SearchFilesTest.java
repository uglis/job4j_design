package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchFilesTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenCheckPredicate() throws IOException {
        folder.newFile("test.class");
        SearchFiles searchFiles = new SearchFiles((path -> path.toFile().getName().endsWith("class")));
        List<Path> expected = List.of(
                Path.of(folder.getRoot() + "/test.class")
        );
        Path source = Paths.get(folder.getRoot().toString());
        Files.walkFileTree(source, searchFiles);
        List<Path> rsl = searchFiles.getPaths();
        assertThat(rsl, is(expected));
    }
}