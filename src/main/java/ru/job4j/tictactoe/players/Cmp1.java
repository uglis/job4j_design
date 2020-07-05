package ru.job4j.tictactoe.players;

import java.util.Random;

public class Cmp1 extends Player {
    public Cmp1(String name) {
        super(name);
    }

    @Override
    public String choosePoint() {
        int x = random();
        int y = random();
        return String.format("%d %d", x, y);
    }

    public int random() {
        return new Random().nextInt(3);
    }
}
