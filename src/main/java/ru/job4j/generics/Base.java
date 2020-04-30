package ru.job4j.generics;

/**
 * 5.2.2. Реализовать Store<T extends Base> [#279225]
 */
public class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
