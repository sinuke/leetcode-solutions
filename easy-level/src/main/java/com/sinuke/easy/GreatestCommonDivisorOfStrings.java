package com.sinuke.easy;

public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        int l = gcd(str1.length(), str2.length());
        String s1 = str1.substring(0, l), s2 = str2.substring(0, l);
        int i = l, j = l;
        while (i < str1.length() || j < str2.length()) {
            var ts1 = i < str1.length() ? str1.substring(i, i + l) : s1;
            var ts2 = j < str2.length() ? str2.substring(j, j + l) : s2;
            if (!ts1.equals(s1) || !ts2.equals(s2) || !ts1.equals(ts2)) return "";
            s1 = ts1;
            s2 = ts2;
            i += l;
            j += l;
        }
        return s1.equals(s2) ? s1 : "";
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

}
