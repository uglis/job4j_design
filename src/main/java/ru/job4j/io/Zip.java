package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 5.1. Архивировать проект. [#279261]
 */
public class Zip {
    /**
     * Упаковывыем в архив указаные файлы в списке.
     *
     * @param sources список файлов.
     * @param target  путь и название собранного архив
     */
    public void packFiles(List<Path> sources, Path target) {
        try (var zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toString())))) {
            for (Path file : sources) {
                ZipEntry zipEntry = new ZipEntry(file.toFile().getAbsolutePath().substring(3));
                zip.putNextEntry(zipEntry);
                try (var out = new BufferedInputStream(new FileInputStream(file.toFile().toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Архивировать один файл.
     *
     * @param source нужынй файл.
     * @param target путь и название к архиву.
     */
    public void packSingleFile(Path source, Path target) {
        try (var zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toString())))) {
            zip.putNextEntry(new ZipEntry(source.toFile().getAbsolutePath().substring(3)));
            try (var out = new BufferedInputStream(new FileInputStream(source.toString()))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Создаём архив исходя из аргументов.
     *
     * @param args аргументы :
     *             -d : указываем ныжную директорию.
     *             -e : исключаем не нужные файлы.
     *             -o : название и путь к полученому архиву.
     */
    public static void main(String[] args) {
        Zip zip = new Zip();
        ArgZip argZip = new ArgZip(args);
        List<Path> paths = Search.seekBy(Paths.get(argZip.directory()), argZip.exclude());
        zip.packFiles(paths, Paths.get(argZip.output()));
    }
}
