package com.sinuke.easy;

public class CountRotationsWithExactlyKEqualAdjacentPairs {

    public int countRotations(String s, int k) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);

            int cnt = 0;
            for (int j = 0; j < s.length() - 1; j++) {
                if (s.charAt(j) == s.charAt(j + 1)) cnt++;
            }

            if (cnt == k) total++;
        }
        return total;
    }

}
