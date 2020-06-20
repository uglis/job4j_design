package ru.job4j.references;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Реализации кеша на SoftReference [#279308]
 */
public class Cache<K, V> {
    private Map<K, SoftReference<V>> cache = new HashMap<>();

    public void add(K key, SoftReference<V> value) {
        cache.put(key, value);
    }

    public Map<K, SoftReference<V>> getCache() {
        return cache;
    }
}
