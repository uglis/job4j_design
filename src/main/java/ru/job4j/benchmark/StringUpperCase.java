package ru.job4j.benchmark;

import java.util.HashMap;
import java.util.Map;

public class StringUpperCase {
    private static Map<Character, Character> alphabet = new HashMap<>();
    static {
        alphabet.put('a', 'A');
        alphabet.put('b', 'B');
        alphabet.put('c', 'C');
        alphabet.put('d', 'D');
        alphabet.put('e', 'E');
        alphabet.put('f', 'F');
        alphabet.put('g', 'G');
        alphabet.put('h', 'H');
        alphabet.put('i', 'I');
        alphabet.put('j', 'J');
        alphabet.put('k', 'K');
        alphabet.put('l', 'L');
        alphabet.put('m', 'M');
        alphabet.put('n', 'N');
        alphabet.put('o', 'O');
        alphabet.put('p', 'P');
        alphabet.put('q', 'Q');
        alphabet.put('r', 'R');
        alphabet.put('s', 'S');
        alphabet.put('t', 'T');
        alphabet.put('u', 'U');
        alphabet.put('v', 'V');
        alphabet.put('w', 'W');
        alphabet.put('x', 'X');
        alphabet.put('y', 'Y');
        alphabet.put('z', 'Z');
    }

    public static String toUpperCase(String text) {
        char[] rsl = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (alphabet.containsKey(rsl[i])) {
                rsl[i] = alphabet.get(rsl[i]);
            }
            sb.append(rsl[i]);
        }
        return sb.toString();
    }
}
