package ru.job4j.references;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * Реализации кеша на SoftReference [#279308]
 */
public class LoadDoc {
    private static Cache<String, ArrayList<String>> cache = new Cache<>();

    /**
     * checking if cache has value of this key.
     * if cache doesn't have this key or value is null, will be downloaded from file.
     *
     * @param file path.
     */
    public static void load(String file) {
        if (cache.getCache().get(file) == null) {
            ArrayList<String> lines = new ArrayList<>();
            SoftReference<ArrayList<String>> soft = new SoftReference<>(lines);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                reader.lines().forEach(lines::add);
                cache.add(file, soft);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Cache<String, ArrayList<String>> getCache() {
        return cache;
    }

    /**
     * Start program with parameter.
     *
     * @param args path
     */
    public static void main(String[] args) {
        LoadDoc.load(args[0]);
        System.out.println(cache.getCache().get(args[0]).get());
    }
}
