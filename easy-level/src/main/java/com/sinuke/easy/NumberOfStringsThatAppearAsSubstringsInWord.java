package com.sinuke.easy;

public class NumberOfStringsThatAppearAsSubstringsInWord {

    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (var pattern : patterns) {
            if (word.contains(pattern)) count++;
        }
        return count;
    }

}
