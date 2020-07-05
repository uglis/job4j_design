package ru.job4j.tictactoe;

import java.util.function.Predicate;

public interface ILogic {

    String[][] getField();

    boolean setPoint(int x, int y, String figure);

    boolean isPlaceFree(int x, int y);

    boolean fieldNotFull();

    boolean fillBy(Predicate<String> predicate);

    boolean winX();

    boolean winO();
}
