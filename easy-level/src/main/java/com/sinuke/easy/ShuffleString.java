package com.sinuke.easy;

public class ShuffleString {

    public String restoreString(String s, int[] indices) {
        var result = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }

        return new String(result);
    }

}
