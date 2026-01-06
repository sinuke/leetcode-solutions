package com.sinuke.easy;

public class LargestEvenNumber {

    public String largestEven(String s) {
        int last = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '2') {
                last = i;
                break;
            }
        }

        return last == -1 ? "" : s.substring(0, last + 1);
    }

}
