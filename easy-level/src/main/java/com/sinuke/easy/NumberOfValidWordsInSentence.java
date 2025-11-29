package com.sinuke.easy;

public class NumberOfValidWordsInSentence {

    public int countValidWords(String sentence) {
        String[] tokens = sentence.split(" ");
        int count = 0;
        for (String token : tokens) {
            count += !token.isEmpty() && isValid(token) ? 1 : 0;
        }
        return count;
    }

    private boolean isValid(String w) {
        int hyphons = 0;

        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);

            if (c == '-') {
                if (i == 0 || i == w.length() - 1 || hyphons == 1 || !Character.isLetter(w.charAt(i - 1)) || !Character.isLetter(w.charAt(i + 1))) return false;
                hyphons++;
            } else if ((c == '!' || c == '.' || c == ',') && i != w.length() - 1) return false;
            else if (Character.isDigit(c)) return false;
        }

        return true;
    }

}
