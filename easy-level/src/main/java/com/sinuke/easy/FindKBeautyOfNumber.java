package com.sinuke.easy;

public class FindKBeautyOfNumber {

    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        if (s.length() < k) return 0;

        int cnt = 0;
        for (int i = 0; i < s.length() - k + 1; i++) {
            int n = Integer.parseInt(s.substring(i, i + k));
            if (n != 0 && num % n == 0) cnt++;
        }
        return cnt;
    }

}
