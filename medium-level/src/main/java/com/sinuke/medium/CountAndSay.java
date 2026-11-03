package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {

    // 4 ms - 77.58%
    public String countAndSay(int n) {
        String[] str = new String[n];
        str[0] = "1";
        int i = 1;
        while (i < n) {
            str[i] = toInt(toMap(str[i - 1]));
            i++;
        }
        return str[i - 1];
    }

    // 5 ms - 75.87%
    public String countAndSay2(int n) {
        return countAndSay(1, n, "1");
    }

    private String countAndSay(int step, int n, String s) {
        if (step == n) return s;

        List<Pair> lst = toMap(s);

        return countAndSay(step + 1, n, toInt(lst));
    }

    private List<Pair> toMap(String s) {
        List<Pair> lst = new ArrayList<>(s.length());
        var p = new Pair();
        p.d = s.charAt(0) - '0';
        p.c = 1;
        lst.add(p);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) lst.getLast().c += 1;
            else {
                p = new Pair();
                p.d = s.charAt(i) - '0';
                p.c = 1;
                lst.add(p);
            }
        }

        return lst;
    }

    private String toInt(List<Pair> lst) {
        var sb = new StringBuilder();
        for (Pair p : lst) {
            sb.append(p.c).append(p.d);
        }
        return sb.toString();
    }


    private static class Pair {
        int d;
        int c;
    }

}
