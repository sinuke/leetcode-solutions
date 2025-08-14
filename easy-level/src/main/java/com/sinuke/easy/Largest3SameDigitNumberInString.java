package com.sinuke.easy;

public class Largest3SameDigitNumberInString {

    // 2 ms
    public String largestGoodInteger(String num) {
        int counter = 1;
        char prev = num.charAt(0);
        String result = "";
        for (int i = 1; i < num.length(); i++) {
            if (prev == num.charAt(i)) {
                counter++;
                if (counter == 3) {
                    String str = num.substring(i - 2, i + 1);
                    if (str.compareTo(result) > 0) result = str;
                    counter = 1;
                }
            } else counter = 1;
            prev = num.charAt(i);
        }
        return result;
    }

}
