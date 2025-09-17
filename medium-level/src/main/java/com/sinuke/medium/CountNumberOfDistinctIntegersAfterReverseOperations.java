package com.sinuke.medium;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfDistinctIntegersAfterReverseOperations {

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length * 2);
        for (int num : nums) {
            set.add(num);
            int n = 0;
            while (num > 0) {
                n = n * 10 + num % 10;
                num /= 10;
            }
            set.add(n);
        }
        return set.size();
    }

}
