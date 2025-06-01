package com.sinuke.easy;

public class FindMostFrequentVowelAndConsonant {

    public int maxFreqSum(String s) {
        int vowelFreq = 0, consonantFreq = 0;
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            int indx = c - 'a';
            freqs[indx] += 1;
            if (isVowel(c)) vowelFreq = Math.max(vowelFreq, freqs[indx]);
            else consonantFreq = Math.max(consonantFreq, freqs[indx]);
        }

        return vowelFreq + consonantFreq;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
