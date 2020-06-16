package ru.job4j.gb;

import java.util.List;

/**
 *  Демонстрация работы GC[1589#279299]
 */
public class User {
    private String name;
    private int age;
    private String date;
    private List<String> movies;

    public User(String name, int age, String date, List<String> movies) {
        this.name = name;
        this.age = age;
        this.date = date;
        this.movies = movies;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("my finalize");
    }
}
