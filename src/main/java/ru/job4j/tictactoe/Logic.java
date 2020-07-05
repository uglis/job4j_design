package ru.job4j.tictactoe;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Logic implements ILogic {
    private int sizeX = 3;
    private int sizeY = 3;
    private String[][] field = new String[sizeX][sizeY];

    /**
     * When create instance fill field with spaces.
     */
    public Logic() {
        for (String[] strings : field) {
            Arrays.fill(strings, " ");
        }
    }

    /**
     * Field.
     *
     * @return field.
     */
    public String[][] getField() {
        return field;
    }

    /**
     * Set point if it's possible.
     *
     * @param x      x.
     * @param y      y.
     * @param figure figure 'X' or 'O'.
     * @return true or false.
     */
    public boolean setPoint(int x, int y, String figure) {
        if (checkPoint(x, y) && isPlaceFree(x, y)) {
            field[x][y] = figure;
            return true;
        }
        return false;
    }

    /**
     * Checking if x and y match size.
     *
     * @param x x.
     * @param y y.
     * @return true of false.
     */
    private boolean checkPoint(int x, int y) {
        return x < sizeX && y < sizeY;
    }

    /**
     * Checking if select index is free.
     *
     * @param x x.
     * @param y y.
     * @return true of false.
     */
    @Override
    public boolean isPlaceFree(int x, int y) {
        return field[x][y].equals(" ");
    }

    /**
     * Checking out if have free space on field.
     *
     * @return true of false.
     */
    @Override
    public boolean fieldNotFull() {
        Optional<String> rsl = Stream.of(field)
                .flatMap(Arrays::stream)
                .filter(s -> s.equals(" "))
                .findAny();
        return rsl.isPresent();
    }

    /**
     * Checking if we have a winner with 'X'.
     *
     * @return true of false.
     */
    @Override
    public boolean winX() {
        return fillBy(s -> s.equals("X"));
    }

    /**
     * Checking if we have a winner with 'O'.
     *
     * @return true of false.
     */
    @Override
    public boolean winO() {
        return fillBy(s -> s.equals("O"));
    }

    /**
     * We check any winning option.
     *
     * @param predicate predicate.
     * @return true of false.
     */
    @Override
    public boolean fillBy(Predicate<String> predicate) {
        boolean result = false;
        int countHor = 0;
        int countVer = 0;
        int countDiagonal1 = 0;
        int countDiagonal2 = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (predicate.test(field[i][j])) {
                    countHor++;
                }
                if (predicate.test(field[j][i])) {
                    countVer++;
                }
                if (i == j && predicate.test(field[i][j])) {
                    countDiagonal1++;
                }
                if (i + j == field.length - 1 && predicate.test(field[i][j])) {
                    countDiagonal2++;
                }
            }
            if (countHor == field.length
                    || countVer == field.length
                    || countDiagonal1 == field.length
                    || countDiagonal2 == field.length) {
                result = true;
                break;
            }
            countHor = 0;
            countVer = 0;
        }
        return result;
    }

    /**
     * Set new size X.
     *
     * @param sizeX size.
     */
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    /**
     * Set new size Y.
     *
     * @param sizeY size.
     */
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
}
