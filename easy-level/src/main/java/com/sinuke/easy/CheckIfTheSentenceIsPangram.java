package com.sinuke.easy;

public class CheckIfTheSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;

        byte[] flags = new byte[26];
        int count = 0;
        for (char c : sentence.toCharArray()) {
            if (flags[c - 'a'] == 0) count++;
            if (count == 26) return true;
            flags[c - 'a'] = 1;
        }

        return false;
    }

}
