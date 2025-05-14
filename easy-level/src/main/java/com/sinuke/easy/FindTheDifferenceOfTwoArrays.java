package com.sinuke.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        for (int num : nums1) {
            if (set2.contains(num)) {
                set1.remove(num);
                set2.remove(num);
            }
        }


        return List.of(new ArrayList<>(set1), new ArrayList<>(set2));
    }

}
