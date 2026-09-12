package com.sinuke.easy;

import java.util.List;

class MinimumRightShiftsToSortArray {

    public int minimumRightShifts(List<Integer> nums) {
        int p = -1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                // sorted
            } else if (p == -1) {
                if (nums.getLast() > nums.getFirst()) return -1;
                p = i;
            } else return -1;
        }

        return p == -1 ? 0 : nums.size() - p;
    }

}
