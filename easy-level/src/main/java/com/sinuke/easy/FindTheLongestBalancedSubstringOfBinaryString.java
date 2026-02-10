package com.sinuke.easy;

public class FindTheLongestBalancedSubstringOfBinaryString {

    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (prev == '0' && c == '1') {
                int j = i - 1, k = i;
                while (j >= 0 && s.charAt(j) == '0' && k < s.length() && s.charAt(k) == '1') {
                    ans = Math.max(k - j + 1, ans);
                    j--; k++;
                }
            }
            prev = c;
        }
        return ans;
    }

}
