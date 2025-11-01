package com.sinuke.easy;

public class EqualScoreSubstrings {

    public boolean scoreBalance(String s) {
        int[] sum = new int[s.length()];
        sum[0] = (s.charAt(0) - 'a') + 1;

        for (int i = 1; i < s.length(); i++) {
            sum[i] = sum[i - 1] + (s.charAt(i) - 'a') + 1;
        }

        if (sum[sum.length - 1] % 2 != 0) return false;
        int target = sum[sum.length - 1] / 2, l = 0, r = sum.length - 1;
        while (r >= l) {
            int mid = (r + l) / 2;
            if (sum[mid] == target) return true;
            else if (sum[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }

}
