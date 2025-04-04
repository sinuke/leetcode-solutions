package com.sinuke.easy;

public class FindMaximumNumberOfStringPairs {

    public int maximumNumberOfStringPairs(String[] words) {
        String[] reversed = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversed[i] = new StringBuilder(words[i]).reverse().toString();
        }

        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(reversed[j])) count++;
            }
        }

        return count;
    }

}
