package com.sinuke.easy;

public class CountPrefixesOfGivenString {

    public int countPrefixes(String[] words, String s) {
        int count = 0;

        for (var word : words) {
            if (s.startsWith(word)) count++;
        }

        return count;
    }

}
