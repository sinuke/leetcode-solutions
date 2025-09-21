package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) answer.add(index + 1);
            nums[index] *= -1;
        }
        return answer;
    }

}
