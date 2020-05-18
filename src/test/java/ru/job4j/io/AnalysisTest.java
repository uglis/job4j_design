package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalysisTest {
    @Test
    public void whenHave2TimeNotWorkServer() {
        Analysis analysis = new Analysis();
        analysis.unavailable("./src/data/server.txt", "./src/data/target.txt");
        List<String> rsl = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("./src/data/target.txt"))) {
             rsl = reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> expected = new ArrayList<>(List.of(
                "10:57:01;10:59:01",
                "11:01:02;11:02:02"
        ));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenHaveOneTimeNotWorkServer() {
        Analysis analysis = new Analysis();
        analysis.unavailable("./src/data/server1.txt", "./src/data/target1.txt");
        List<String> rsl = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("./src/data/target1.txt"))) {
            rsl = reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> expected = new ArrayList<>(List.of(
                "14:20:02;22:05:09"
        ));
        assertThat(rsl, is(expected));
    }
}