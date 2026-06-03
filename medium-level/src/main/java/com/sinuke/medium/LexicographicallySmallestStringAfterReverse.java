package com.sinuke.medium;

public class LexicographicallySmallestStringAfterReverse {

    public String lexSmallest(String s) {
        int n = s.length();
        String result = s;
        for (int k = 2; k <= n; k++) {
            StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
            int i = 0;
            if (k != n) sb2.append(s, 0, n - k);

            while (i < k) {
                sb1.append(s.charAt(k - i - 1));
                sb2.append(s.charAt(n - i - 1));
                i++;
            }
            if (i < n) sb1.append(s, i, n);

            String s1 = sb1.toString(), s2 = sb2.toString();
            if (s1.compareTo(result) < 0) result = s1;
            if (s2.compareTo(result) < 0) result = s2;
        }
        return result;
    }

}
