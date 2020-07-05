package ru.job4j.tictactoe.players;

import java.util.Objects;

abstract public class Player implements Action {
    private String name;
    private String figure;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name)
                && Objects.equals(figure, player.figure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, figure);
    }

    @Override
    public String toString() {
        return "Player{"
                + "name='" + name + '\''
                + '}';
    }
}
