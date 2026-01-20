package com.sinuke.easy;

public class CountResiduePrefixes {

    public int residuePrefixes(String s) {
        char[] chars = new char[26];
        int count = 0, size = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            chars[j]++;
            size += chars[j] == 1 ? 1 : 0;
            if ((i + 1) % 3 == size) count++;
        }
        return count;
    }

}
