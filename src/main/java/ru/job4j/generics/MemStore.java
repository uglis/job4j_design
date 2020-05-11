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
        int index = indexOf(id);
        if (index != -1) {
            data.set(index, model);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            data.remove(index);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);
        T el = null;
        if (index != -1) {
            el = data.get(index);
        }
        return el;
    }

    /**
     * Поиск индека элемента по id.
     *
     * @param id id
     * @return индекс элемента.
     */
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
