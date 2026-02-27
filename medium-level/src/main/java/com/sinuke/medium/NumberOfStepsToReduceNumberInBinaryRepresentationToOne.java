package com.sinuke.medium;

public class NumberOfStepsToReduceNumberInBinaryRepresentationToOne {

    public int numSteps(String s) {
        int steps = 0;
        while (!"1".equals(s)) {
            if (s.charAt(s.length() - 1) == '0') s = s.substring(0, s.length() - 1);
            else s = convertOdd(s);
            steps++;
        }
        return steps;
    }

    private String convertOdd(String s) {
        var sb = new StringBuilder(s);
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == '1') sb.setCharAt(i--, '0');

        if (i == -1) sb.insert(0, '1');
        else sb.setCharAt(i, '1');

        return sb.toString();
    }

}
