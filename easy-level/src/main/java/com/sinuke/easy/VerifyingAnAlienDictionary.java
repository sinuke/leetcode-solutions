package com.sinuke.easy;

public class VerifyingAnAlienDictionary {

    private final byte[] abc = new byte[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (byte i = 0; i < order.length(); i++) {
            abc[order.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < words.length - 1) {
            if (!checkWords(words[i], words[i + 1])) return false;
            i++;
        }

        return true;
    }

    private boolean checkWords(String word1, String word2) {
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            byte c1 = abc[word1.charAt(i) - 'a'];
            byte c2 = abc[word2.charAt(i) - 'a'];

            if (c1 > c2) return false;
            if (c1 < c2) return true;

            i++;
        }
        return word1.length() <= word2.length();
    }

}
