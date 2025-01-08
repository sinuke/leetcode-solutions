package com.sinuke.easy;

public class CountPrefixAndSuffixPairsI {

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) count++;
            }
        }

        return count;
    }

}
