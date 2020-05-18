package ru.job4j.io;

import java.io.FileOutputStream;

/**
 * 0.1. FileOutputStream. [#279255]
 */
public class Multiple {
    public void writeMultipleInFile() {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i <= 10; i++) {
                 out.write(String.format("1 * %d = %d;", i, i).getBytes());
                 out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Multiple().writeMultipleInFile();
    }
}
