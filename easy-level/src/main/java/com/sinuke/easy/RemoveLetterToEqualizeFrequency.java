package com.sinuke.easy;

public class RemoveLetterToEqualizeFrequency {

    public boolean equalFrequency(String word) {
        for (int i = 0; i < word.length(); i++) {
            boolean result = calc(word, i);
            if (result) return true;
        }
        return false;
    }

    private boolean calc(String word, int index) {
        int[] freq = new int[26];

        for (int i = 0; i < word.length(); i++) {
            if (i != index) freq[word.charAt(i) - 'a']++;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (freq[i] > max) max = freq[i];
                if (freq[i] < min) min = freq[i];
            }
        }

        return min == max;
    }

}
