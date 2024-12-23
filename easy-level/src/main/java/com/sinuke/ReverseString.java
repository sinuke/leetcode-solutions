package com.sinuke;

public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        char temp;

        while (left < s.length - left - 1) {
            temp = s[left];
            s[left] = s[s.length - left - 1];
            s[s.length - left - 1] = temp;

            left++;
        }
    }

}
