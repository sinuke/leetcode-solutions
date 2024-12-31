package com.sinuke.easy;

public class ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {
        var chars = word.toCharArray();
        int point = -1;
        int i = 0;

        while (point == -1 && i < chars.length) {
            if (chars[i] == ch) point = i;
            i++;
        }

        if (point == -1) return word;

        i = point;
        while (i > point / 2) {
            var tmp = chars[i];
            chars[i] = chars[point - i];
            chars[point - i] = tmp;
            i--;
        }

        return new String(chars);
    }

}
