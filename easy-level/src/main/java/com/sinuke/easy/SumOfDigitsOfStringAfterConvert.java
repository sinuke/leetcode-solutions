package com.sinuke.easy;

public class SumOfDigitsOfStringAfterConvert {

    public int getLucky(String s, int k) {
        int num = 0;
        for (char c : s.toCharArray()) {
            int d = (c - 'a') + 1;
            num += (d > 9) ? d % 10 + d / 10 : d;
        }
        k--;

        while (k > 0) {
            int prev = num;
            int sum = 0;
            while (prev > 0) {
                sum += prev % 10;
                prev /= 10;
            }
            num = sum;
            k--;
        }

        return num;
    }

}
