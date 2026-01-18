package com.sinuke.easy;

public class CircularSentence {

    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        char prev = sentence.charAt(0);
        for (int i = 1; i < n; i++) {
            char c = sentence.charAt(i);
            if (c == ' ') {
                if (prev != sentence.charAt(i + 1)) return false;
            } else prev = c;
        }

        return sentence.charAt(0) == sentence.charAt(n - 1);
    }

}
