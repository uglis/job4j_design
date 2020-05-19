package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 4.1. Сканирование файловой системы. [#279252]
 */
public class Search {
    /**
     * Сканируем папку и находим файлы с нужным окончанием.
     *
     * @param root источник.
     * @param ext  окончание файла.
     * @return список путей с нужными оканчаниями.
     */
    public static List<Path> search(Path root, String ext) {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        try {
            Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths();
    }
}
