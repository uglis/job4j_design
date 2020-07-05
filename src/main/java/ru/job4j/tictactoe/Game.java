package ru.job4j.tictactoe;

import ru.job4j.tictactoe.players.Cmp1;
import ru.job4j.tictactoe.players.Player;
import ru.job4j.tictactoe.players.User;

public class Game {
    private final ILogic logic;
    private final Player player1;
    private final Player player2;
    private final IConsoleHelper consoleHelper;

    public Game(ILogic logic, Player player1, Player player2, IConsoleHelper consoleHelper) {
        this.logic = logic;
        this.player1 = player1;
        this.player2 = player2;
        this.consoleHelper = consoleHelper;
    }

    /**
     * Start play.
     */
    public void start() {
        welcome();
        while (true) {
            showCurrentField();
            setPoint(player1, String.format("player %s turn: ", player1.getName()));
            if (winner(
                    logic.winX(), String.format("player %s win!!!", player1.getName()))
                    || draw(logic.fieldNotFull())) {
                break;
            }
            showCurrentField();
            setPoint(player2, String.format("player %s turn: ", player2.getName()));
            if (winner(
                    logic.winO(), String.format("player %s win!!!", player2.getName()))
                    || draw(logic.fieldNotFull())) {
                break;
            }
        }
    }

    /**
     * Welcome text.
     */
    private void welcome() {
        consoleHelper.showMessage("Hello!!!");
        consoleHelper.showMessage("Let start!!! choose your point");
        player1.setFigure("X");
        player2.setFigure("O");
    }

    /**
     * System message if someone won.
     *
     * @param win    condition.
     * @param winner message.
     * @return true of false.
     */
    private boolean winner(boolean win, String winner) {
        if (win) {
            consoleHelper.showMessage(winner);
            showCurrentField();
            return true;
        }
        return false;
    }

    /**
     * System message if there is no available cell.
     *
     * @param draw condition.
     * @return true or false.
     */
    private boolean draw(boolean draw) {
        if (!draw) {
            consoleHelper.showMessage("play finished whit draw");
            showCurrentField();
            return true;
        }
        return false;
    }

    /**
     * System message and setting point to field if it's possible.
     *
     * @param player     current player.
     * @param playerTurn system message to current player.
     */
    public void setPoint(Player player, String playerTurn) {
        consoleHelper.showMessage(playerTurn);
        String choose;
        boolean rsl = false;
        while (!rsl) {
            consoleHelper.showMessage("enter x and y");
            choose = player.choosePoint();
            rsl = logic.setPoint(
                    Integer.parseInt(choose.split(" ")[0]),
                    Integer.parseInt(choose.split(" ")[1]),
                    player.getFigure());
        }
    }

    /**
     * Show current field.
     */
    private void showCurrentField() {
        consoleHelper.showField(logic.getField());
    }

    /**
     * Test game between Computer and Person.
     *
     * @param args null.
     */
    public static void main(String[] args) {
        Game game = new Game(
                new Logic(),
                new Cmp1("Cmp"), new User("User"),
                new ConsoleHelper());
        game.start();
    }
}
