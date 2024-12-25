package com.sinuke.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<String> result = new ArrayList<>();

        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                result.add(getRange(start, nums[i - 1]));
                start = nums[i];
            }
        }

        result.add(getRange(start, nums[nums.length - 1]));

        return result;
    }

    private String getRange(int start, int end) {
        return start == end ? start + "" : start + "->" + end;
    }

}
