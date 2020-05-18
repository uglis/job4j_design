package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 0.3. BufferedReader. [#279256]
 */
public class LogFilter {
    public static List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            rsl = reader.lines().filter(s -> s.contains("404")).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void save(List<String> list, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            list.forEach(s -> out.write(s + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}
