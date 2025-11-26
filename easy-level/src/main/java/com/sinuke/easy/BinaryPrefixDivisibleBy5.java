package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>(nums.length);
        long num = nums[0] % 5;
        ans.add(num == 0);

        for (int i = 1; i < nums.length; i++) {
            num = (2 * num + nums[i]) % 5;
            ans.add(num == 0);
        }

        return ans;
    }

}
