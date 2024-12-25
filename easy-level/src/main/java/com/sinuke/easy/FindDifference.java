package com.sinuke.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDifference {

    public char findTheDifference(String s, String t) {
        Set<Character> set = new HashSet<>(s.length());

        for (char c : s.toCharArray()) set.add(c);
        for (char c : t.toCharArray()) if (!set.contains(c)) return c;

        return 'a';
    }

    public char findTheDifference2(String s, String t) {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);

        for (char c : t.toCharArray())
            if (Arrays.binarySearch(sc, c) < 0) return c;

        return 'a';
    }

}
