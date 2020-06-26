package ru.job4j.references;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Реализации кеша на SoftReference [#279308]
 */
public class LoadDoc {
    private Map<String, SoftReference<String>> cache = new HashMap<>();

    /**
     * add pair to cache.
     *
     * @param key   key.
     * @param value value
     */
    public void add(String key, SoftReference<String> value) {
        cache.put(key, value);
    }

    /**
     * Read the contents of the file.
     *
     * @param path file.
     * @return line.
     */
    public String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines().forEach(line -> sb.append(line).append(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * @return cache.
     */
    public Map<String, SoftReference<String>> getCache() {
        return cache;
    }

    /**
     * checking if cache has value of this key.
     * if cache doesn't have this key or value is null, will be downloaded from file.
     *
     * @param key path.
     */
    public String load(String key) {
        String rsl;
        if (cache.containsKey(key)) {
            rsl = cache.get(key).get();
            if (rsl == null) {
                rsl = readFile(key);
                cache.put(key, new SoftReference<>(rsl));
            }
        } else {
            rsl = readFile(key);
            cache.put(key, new SoftReference<>(rsl));
        }
        return rsl;
    }

    /**
     * Start program with parameter.
     *
     * @param args path
     */
    public static void main(String[] args) {
        LoadDoc loadDoc = new LoadDoc();
        System.out.println(loadDoc.load(args[0]));
    }
}
