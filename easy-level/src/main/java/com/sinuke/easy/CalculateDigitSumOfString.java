package com.sinuke.easy;

public class CalculateDigitSumOfString {

    public String digitSum(String s, int k) {
        while (s.length() > k) {
            s = round(s, k);
        }
        return s;
    }

    private String round(String s, int k) {
        int sum = 0;
        var sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
            if ((i + 1) % k == 0 || i == s.length() - 1) {
                sb.append(sum);
                sum = 0;
            }
        }
        return sb.toString();
    }

}
