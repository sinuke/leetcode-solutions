package com.sinuke;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        char lastChar = s.charAt(i);
        int result = lastChar == ' ' ? 0 : 1;
        i--;
        while (i >= 0) {
            char currentChar = s.charAt(i);

            if (currentChar != ' ') {
                result++;
            } else if (lastChar != ' ') {
                break;
            }

            lastChar = currentChar;
            i--;
        }

        return result;
    }

}
