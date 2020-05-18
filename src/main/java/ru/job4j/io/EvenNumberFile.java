package ru.job4j.io;

import java.io.FileInputStream;

/**
 * 0.2. FileInputStream [#279263]
 */
public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder sb = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                sb.append((char) read);
            }
            String[] rsl = sb.toString().split(System.lineSeparator());
            for (String s : rsl) {
                if (Integer.parseInt(s) % 2 == 0) {
                    System.out.println(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
