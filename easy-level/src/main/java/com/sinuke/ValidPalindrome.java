package com.sinuke;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // numeric - [48..57]
        // A - Z - [65..90]
        // a - z - [97..122]

        int left = 0, right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            leftChar = normalize(leftChar);
            rightChar = normalize(rightChar);

            if (leftChar == 0) left++;
            else if (rightChar == 0) right--;
            else {
                if (leftChar != rightChar) return false;
                left++;
                right--;
            }
        }

        return true;
    }

    private char normalize(char chr) {
        if ((chr >= '0' && chr <= '9') || (chr >= 'a' && chr <= 'z')) return chr;
        else if (chr >= 'A' && chr <= 'Z') return (char)(chr + 32);
        return (char) 0;
    }

}
