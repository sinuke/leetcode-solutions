package com.sinuke.easy;

public class CheckIfWordEqualsSummationOfTwoWords {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        var sb = new StringBuilder();
        for (char c : firstWord.toCharArray()) sb.append(c - 'a');
        long n = Long.parseLong(sb.toString());

        sb.setLength(0);
        for (char c : secondWord.toCharArray()) sb.append(c - 'a');
        long sum = n + Long.parseLong(sb.toString());

        sb.setLength(0);
        for (char c : targetWord.toCharArray()) sb.append(c - 'a');
        return sum == Long.parseLong(sb.toString());
    }

}
