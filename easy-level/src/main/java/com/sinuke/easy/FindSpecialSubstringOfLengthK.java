package com.sinuke.easy;

public class FindSpecialSubstringOfLengthK {

    public boolean hasSpecialSubstring(String s, int k) {
        int cnt = 1;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) cnt++;
            else {
                if (k == cnt) return true;
                cnt = 1;
                prev = s.charAt(i);
            }
        }
        return cnt == k;
    }

}
