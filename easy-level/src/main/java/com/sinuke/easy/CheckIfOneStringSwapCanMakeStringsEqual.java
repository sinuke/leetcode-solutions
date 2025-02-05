package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0, i = 0;
        Set<Character> set1  = new HashSet<>();
        Set<Character> set2  = new HashSet<>();

        while (i < s1.length() && count <= 2) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                set1.add(s1.charAt(i));
                set2.add(s2.charAt(i));
            }

            i++;
        }

        return (count == 0 || count == 2) && set1.equals(set2);
    }

}
