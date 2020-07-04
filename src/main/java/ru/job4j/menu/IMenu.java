package ru.job4j.menu;

/**
 * Create Menu. [#279292].
 *
 * @param <E>
 */
public interface IMenu<E> {
    void addItem(E value);

    void addSubItem(E parent, E child);

    E getItem(E value);

    boolean removeItem(E value);

    void action(E value);

}
