package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * 2. Анализ доступности сервера. [#279260]
 */
public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                while (line != null && (line.contains("200") || line.contains("300"))) {
                    line = reader.readLine();
                }
                if (line != null) {
                    sb.append(line.split(" ")[1]).append(";");
                }
                while (line != null && (line.contains("400") || line.contains("500"))) {
                    line = reader.readLine();
                }
                if (line != null) {
                    sb.append(line.split(" ")[1]).append(System.lineSeparator());
                }
            }
            out.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
