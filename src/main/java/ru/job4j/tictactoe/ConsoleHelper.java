package ru.job4j.tictactoe;

public class ConsoleHelper implements IConsoleHelper {
    /**
     * Show system message.
     *
     * @param message message.
     */
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Show field.
     *
     * @param field current field.
     */
    @Override
    public void showField(String[][] field) {
        System.out.println("..................");
        for (String[] strings : field) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
        System.out.println("..................");
    }
}
