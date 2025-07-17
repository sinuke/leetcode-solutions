package com.sinuke.easy;

public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        byte[] abc = new byte[26];
        for (byte i = 0; i < order.length(); i++) {
            abc[order.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < words.length - 1) {
            if (!checkWords(abc, words[i], words[i + 1])) return false;
            i++;
        }

        return true;
    }

    private boolean checkWords(byte[] abc, String word1, String word2) {
        if (word1.length() > word2.length()) return false;
        int i = 0;
        while (i < word1.length()) {
            int c1 = abc[word1.charAt(i) - 'a'];
            int c2 = abc[word2.charAt(i) - 'a'];

            if (c1 > c2) return false;
            if (c1 < c2) return true;
            i++;
        }
        return true;
    }

}
