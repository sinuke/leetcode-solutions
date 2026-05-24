package com.sinuke.medium;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int i = 1, j = 0, k = 1, prev = nums[0], cnt = 1;
        while (i < nums.length) {
            if (nums[i] == prev) {
                cnt++;
                if (cnt == 2) {
                    nums[++j] = nums[i];
                    k++;
                }
            } else {
                nums[++j] = nums[i];
                k++;
                cnt = 1;
            }
            prev = nums[i++];
        }
        return k;
    }

}
