package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

class LongestUnequalAdjacentGroupsSubsequenceI {

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length, i = 1;
        List<Integer> l = new ArrayList<>(n);
        l.add(0);
        while (i < n) {
            if (groups[i] != groups[l.getLast()]) l.add(i);
            i++;
        }

        return l.stream()
                .map(indx -> words[indx])
                .toList();
    }

}
