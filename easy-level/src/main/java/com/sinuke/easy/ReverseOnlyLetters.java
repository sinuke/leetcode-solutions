package com.sinuke.easy;

public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        char[] result = new char[s.length()];
        int pos = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isLetter(s.charAt(i))) {
                while (!isLetter(s.charAt(pos))) {
                    pos++;
                }
                result[pos++] = s.charAt(i);
            }
            else result[i] = s.charAt(i);
        }
        return new String(result);
    }

    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

}
