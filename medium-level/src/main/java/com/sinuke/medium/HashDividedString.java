package com.sinuke.medium;

public class HashDividedString {

    public String stringHash(String s, int k) {
        int n = s.length(), sum = 0, j = 0;
        var sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - 'a';
            j++;

            if (j == k) {
                char hashedChar = (char) (sum % 26 + 'a');
                sb.append(hashedChar);
                sum = 0;
                j = 0;
            }
        }
        return sb.toString();
    }

}
