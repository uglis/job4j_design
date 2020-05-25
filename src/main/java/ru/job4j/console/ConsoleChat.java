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
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String EXIT = "закончить";

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
        List<String> allChat = new ArrayList<>();
        while (!line.equals(EXIT)) {
            if (line.equals(STOP)) {
                while (!line.equals(CONTINUE)) {
                    allChat.add(line + System.lineSeparator());
                    line = SCANNER.nextLine();
                }
            }
            allChat.add(line + System.lineSeparator());
            String randomText = text.get(new Random().nextInt(text.size() - 1));
            System.out.println(randomText);
            allChat.add(randomText + System.lineSeparator());
            line = SCANNER.nextLine();
        }
        try (var out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(exit)))) {
            allChat.forEach(out::write);
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
