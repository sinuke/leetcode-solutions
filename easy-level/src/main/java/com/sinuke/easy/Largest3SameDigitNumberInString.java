package com.sinuke.easy;

public class Largest3SameDigitNumberInString {

    public String largestGoodInteger(String num) {
        int counter = 0, max = -1, prev = -1;
        var result = "";
        for (int i = 0; i < num.length(); i++) {
            int val = num.charAt(i) - '0';
            if (prev == val) {
                counter++;
                if (counter == 3) {
                    if (val > max) {
                        result = num.substring(i - 2, i + 1);
                        max = val;
                    }
                    counter = 1;
                }
            } else counter = 1;
            prev = val;
        }
        return result;
    }

}
