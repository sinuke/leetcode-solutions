package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class FindCommonElementsBetweenTwoArrays {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (var num : nums2) set2.add(num);

        int counter = 0;
        for (var num : nums1) {
            set1.add(num);
            if (set2.contains(num)) counter++;
        }

        int[] result = new int[2];
        result[0] = counter;

        counter = 0;
        for (var num : nums2) {
            if (set1.contains(num)) counter++;
        }
        result[1] = counter;

        return result;
    }

}
