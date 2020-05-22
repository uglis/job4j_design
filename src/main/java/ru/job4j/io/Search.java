package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 5. Валидация параметров запуска. [#279254]
 */
public class Search {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        search(Paths.get(args[0]), args[1]).forEach(System.out::println);
    }

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

    /**
     * Собираем пути из директории,
     * за исключением тех что указаны во втором аргументе.
     *
     * @param dir директория.
     * @param exc исключить указаные файлы.
     * @return список путей.
     */
    public static List<Path> seekBy(Path dir, String exc) {
        SearchFiles searchFiles = new SearchFiles(path -> !(path.toFile().getName().endsWith(exc)));
        try {
            Files.walkFileTree(dir, searchFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchFiles.getPaths();
    }
}
