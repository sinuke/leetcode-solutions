package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegersInString {

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int startDigit = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c) && startDigit == -1) startDigit = i;
            else if (!Character.isDigit(c)) {
                if (startDigit != -1) {
                    set.add(getNumber(word, startDigit, i));
                    startDigit = -1;
                }
            }
        }
        if (startDigit != -1) set.add(getNumber(word, startDigit, word.length()));
        return set.size();
    }

    private String getNumber(String s, int start, int end) {
        String num = s.substring(start, end);
        if (num.charAt(0) == '0') {
            int cnt = 1;
            for (int i = 1; i < num.length(); i++) {
                if (num.charAt(i) != '0') break;
                else cnt++;
            }
            if (cnt == num.length()) return "0";
            else return num.substring(cnt);
        } else return num;
    }

}
