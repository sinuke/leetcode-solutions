package com.sinuke;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    // 4 ms
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) set.add(num);

        Set<Integer> result = new HashSet<>();
        for (int num : nums2)
            if (set.contains(num))
                result.add(num);

        return result.stream().mapToInt(i -> i).toArray();
    }

    // 5 ms
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);

        Set<Integer> set = new HashSet<>();
        for (int j : nums1)
            if (Arrays.binarySearch(nums2, j) >= 0) set.add(j);

        return set.stream().mapToInt(i -> i).toArray();
    }

}
