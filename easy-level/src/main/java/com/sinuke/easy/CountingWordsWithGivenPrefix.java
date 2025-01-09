package com.sinuke.easy;

public class CountingWordsWithGivenPrefix {

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (var word : words) {
            if (word.startsWith(pref)) count++;
        }
        return count;
    }

}
