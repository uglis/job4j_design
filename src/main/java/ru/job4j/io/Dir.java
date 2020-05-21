package ru.job4j.io;

import java.io.File;

/**
 * 4.0. File [#279258]
 */
public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("dir: %s - size : %s", file.getName(), file.length()));
        for (File subfile : file.listFiles()) {
            System.out.println(String.format("file: %s - size: %s", subfile.getName(), subfile.length()));
        }
    }
}
