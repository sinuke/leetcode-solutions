package com.sinuke.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class SortVowelsInString {

    public String sortVowels(String s) {
        Set<Character> vowels = Set.of('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u');
        List<Character> sorted = new ArrayList<>(s.length());
        List<Integer> indxs = new ArrayList<>(s.length());
        char[] schars = s.toCharArray();

        for (int i = 0; i < schars.length; i++) {
            if (vowels.contains(schars[i])) {
                sorted.add(schars[i]);
                indxs.add(i);
            }
        }
        sorted.sort(Comparator.comparingInt(o -> o));

        int j = 0;
        for (int indx : indxs) {
            schars[indx] = sorted.get(j++);
        }

        return new String(schars);
    }

}
