package com.sinuke.easy;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            var tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        int i1 = num1.length() - 1, i2 = num2.length() - 1;
        var sb = new StringBuilder();
        int addition = 0;

        while (i1 >= 0) {
            char ch1 = num1.charAt(i1--);
            char ch2 = i2 >= 0 ? num2.charAt(i2--) : '0';
            int s = sum(ch1, ch2) + addition;
            if (s > 9) {
                addition = 1;
                s -= 10;
            }
            else addition = 0;
            sb.append(s);
        }
        if (addition > 0) sb.append(addition);

        return sb.reverse().toString();
    }

    private int sum(char c1, char c2) {
        return (c1 - '0') + (c2 - '0');
    }

}
