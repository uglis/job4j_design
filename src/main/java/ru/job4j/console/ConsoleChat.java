package ru.job4j.console;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 6. Кодировка. [#279262]
 */
public class ConsoleChat {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        init(args[0], args[1]);
    }

    /**
     * Инициализируем чат.
     *
     * @param source файл с случайнами ответами.
     * @param exit   файл записывающий чат.
     */
    public static void init(String source, String exit) {
        if (source == null || exit == null) {
            throw new IllegalArgumentException("Неправельные аргументы запуска программы");
        }
        List<String> answers = getAnswers(source);
        String line = SCANNER.nextLine();
        chat(answers, line, exit);
    }

    /**
     * Логика чата.
     *
     * @param text список ответов.
     * @param line первое введенное слово пользователем.
     * @param exit путь к файлу записывающий чат.
     */
    private static void chat(List<String> text, String line, String exit) {
        try (var out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(exit)))) {
            while (!line.equals("закончить")) {
                if (line.equals("стоп")) {
                    while (!line.equals("продолжтить")) {
                        out.write(line + System.lineSeparator());
                        line = SCANNER.nextLine();
                    }
                }
                out.write(line + System.lineSeparator());
                String randomText = text.get(new Random().nextInt(text.size() - 1));
                System.out.println(randomText);
                out.write(randomText + System.lineSeparator());
                line = SCANNER.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Получяем список ответов для пользователя.
     *
     * @param source путь к файлу.
     * @return список.
     */
    private static List<String> getAnswers(String source) {
        List<String> text = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(source))) {
            text = reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}
