package com.sinuke.easy;

public class CountSubstringsThatSatisfyKConstraintI {

    public int countKConstraintSubstrings(String s, int k) {
        int answer = 0, cnt0 = 0, cnt1 = 0, l = 0, r = -1;

        while (r < s.length() - 1 && l < s.length()) {
            if (s.charAt(++r) == '0') cnt0++;
            else cnt1++;

            if (cnt0 > k && cnt1 > k) {
                while (cnt0 > k && cnt1 > k) {
                    if (s.charAt(l++) == '0') cnt0--;
                    else cnt1--;
                }
            }

            answer += r - l + 1;
        }

        return answer;
    }

}
