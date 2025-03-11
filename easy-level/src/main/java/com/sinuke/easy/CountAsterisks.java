package com.sinuke.easy;

public class CountAsterisks {

    public int countAsterisks(String s) {
        boolean isPair = false;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '*' && !isPair) count++;
            else if (c == '|' && isPair) isPair = false;
            else if (c == '|') isPair = true;
        }

        return count;
    }

}
