package com.sinuke.easy;

import java.util.Arrays;

public class KeyboardRow {

    private final int[] keyboard = {
            2, // a
            3, // b
            3, // c
            2, // d
            1, // e
            2, // f
            2, // g
            2, // h
            1, // i
            2, // j
            2, // k
            2, // l
            3, // m
            3, // n
            1, // o
            1, // p
            1, // q
            1, // r
            2, // s
            1, // t
            3, // v
            1, // u
            1, // w
            3, // x
            1, // y
            3  // z
    };

    public String[] findWords(String[] words) {
        String[] result = new String[words.length];
        int count = 0;

        for (String word : words) {
            if (checkWord(word)) result[count++] = word;
        }

        return Arrays.copyOfRange(result, 0, count);
    }

    private boolean checkWord(String word) {
        var row = keyboard[getIndex(word.charAt(0))];

        for (int i = 1; i < word.length(); i++) {
            if (row != keyboard[getIndex(word.charAt(i))]) return false;
        }

        return true;
    }

    private int getIndex(char ch) {
        int result = ch - 'a';
        if (result < 0) return ch - 'A';
        else return result;
    }

}
