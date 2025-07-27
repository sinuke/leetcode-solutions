package com.sinuke.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExistenceOfSubstringInStringAndItsReverse {

    public boolean isSubstringPresent(String s) {
        Set<List<Character>> set = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            set.add(List.of(s.charAt(i), s.charAt(i + 1)));
        }

        for (int i = s.length() - 1; i > 0; i--) {
            if (set.contains(List.of(s.charAt(i), s.charAt(i - 1)))) return true;
        }
        return false;
    }

}
