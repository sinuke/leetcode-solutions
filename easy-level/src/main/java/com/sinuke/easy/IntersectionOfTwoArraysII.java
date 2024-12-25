package com.sinuke.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    // slow - 10 ms
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer[]> map = new HashMap<>();

        for (var num : nums1) {
            var val = map.getOrDefault(num, new Integer[]{0, 0});
            val[0]++;
            map.put(num, val);
        }

        for (var num : nums2) {
            var val = map.getOrDefault(num, new Integer[]{0, 0});
            val[1]++;
            map.put(num, val);
        }

        return map.entrySet().stream()
                .filter(e -> e.getValue()[0] > 0 && e.getValue()[1] > 0)
                .flatMapToInt(e -> {
                    int[] result = new int[Math.min(e.getValue()[0], e.getValue()[1])];
                    Arrays.fill(result, e.getKey());
                    return Arrays.stream(result);
                })
                .sorted()
                .toArray();
    }

    // better - 5 ms
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>(nums1.length + nums2.length);
        for (var num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    // also - 5 ms
    public int[] intersect3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i1 = 0, i2 = 0;
        List<Integer> result = new ArrayList<>(nums1.length + nums2.length);
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                result.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] > nums2[i2]) i2++;
            else if (nums1[i1] < nums2[i2]) i1++;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

}
