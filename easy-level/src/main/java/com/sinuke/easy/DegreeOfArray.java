package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Degree> map = new HashMap<>();
        var maxDegree = new Degree();
        maxDegree.count = 1;
        maxDegree.start = 0;
        maxDegree.end = 0;
        maxDegree.length = 1;


        for (int i = 1; i < nums.length; i++) {
            Degree degree;
            if (map.containsKey(nums[i])) {
                degree = map.get(nums[i]);
                degree.count++;
            } else {
                degree = new Degree();
                degree.count = 1;
                degree.start = i;
                map.put(nums[i], degree);
            }

            degree.end = i;
            degree.length = degree.end - degree.start + 1;

            if (degree.count > maxDegree.count) maxDegree = degree;
            else if (degree.count == maxDegree.count && degree.length < maxDegree.length) maxDegree = degree;
        }

        return maxDegree.length;
    }


    private static class Degree {
        int count;
        int start;
        int end;
        int length;
    }

}
