package com.sinuke.easy;

public class ToLowerCase {

    public String toLowerCase(String s) {
        var chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') chars[i] += 32;
        }

        return new String(chars);
    }

}
