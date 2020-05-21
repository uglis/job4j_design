package ru.job4j.io;

/**
 * 5.1. Архивировать проект. [#279261]
 */
public class ArgZip {
    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length < 6) {
            throw new IllegalArgumentException("Не правильные аргументы для запуска програмы");
        }
        return true;
    }

    public String directory() {
        if (valid() && args[0].equals("-d")) {
            return args[1];
        }
        return "";
    }

    public String exclude() {
        if (valid() && args[2].equals("-e")) {
            return args[3];
        }
        return "";
    }

    public String output() {
        if (valid() && args[4].equals("-o")) {
            return args[5];
        }
        return "";
    }
}
