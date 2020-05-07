package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 5.2.2. Реализовать Store<T extends Base> [#279225]
 */
public class MemStore<T extends Base> implements Store<T> {
    private final List<T> data;

    public MemStore() {
        this.data = new ArrayList<>();
    }

    @Override
    public void add(T model) {
        data.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean rsl = false;
        T t = findById(id);
        if (t != null) {
            data.set(indexOf(id), model);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        T t = findById(id);
        if (t != null) {
            data.remove(indexOf(id));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        T rsl = null;
        for (T datum : data) {
            if (datum.getId().equals(id)) {
                rsl = datum;
                break;
            }
        }
        return rsl;
    }

    public int indexOf(String id) {
        int rsl = -1;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
