package com.sinuke.easy;

public class ReverseStringII {

    public String reverseStr(String s, int k) {
        char[] chars = new  char[s.length()];
        int i = 0;
        boolean reverse = true;

        while (i < s.length()) {
            if (reverse) {
                int start = i;
                int j = Math.min(i + k - 1, s.length() - 1);
                while (j >= start) chars[i++] = s.charAt(j--);
            } else {
                int j = 0;
                while (i < s.length() && j < k) {
                    chars[i] = s.charAt(i);
                    i++;
                    j++;
                }
            }

            reverse = !reverse;
        }

        return new String(chars);
    }

}
