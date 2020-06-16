package ru.job4j.gb;

import java.util.ArrayList;

/**
 * Демонстрация работы GC[1589#279299]
 */
public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long freeMem = runtime.freeMemory();

        for (long i = 0; i < 200; i++) {
            User user = new User("user", 23, "12.12.12", new ArrayList<>());
        }
        for (long i = 0; i < 2020; i++) {
            User user = new User("user", 23, "12.12.12", new ArrayList<>());
        }
        long finish = runtime.freeMemory();
        System.out.println(freeMem);
        System.out.println(finish);
        System.out.println(freeMem - finish);
    }


}
