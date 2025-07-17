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
        if (word1.length() > word2.length()) return false;
        int i = 0;
        while (i < word1.length() && word1.charAt(i) == word2.charAt(i)) i++;
        return abc[word1.charAt(i) - 'a'] <= abc[word2.charAt(i) - 'a'];
    }

}
