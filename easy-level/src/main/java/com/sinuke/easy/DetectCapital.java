package com.sinuke.easy;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) count++;
        }

        return (word.length() == count) || (count == 0) || (count == 1 && Character.isUpperCase(word.charAt(0)));
    }

}
