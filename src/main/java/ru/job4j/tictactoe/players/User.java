package ru.job4j.tictactoe.players;

import java.util.Scanner;

public class User extends Player {
    private final Scanner scanner = new Scanner(System.in);

    public User(String name) {
        super(name);
    }

    @Override
    public String choosePoint() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return String.format("%d %d", x, y);
    }
}
