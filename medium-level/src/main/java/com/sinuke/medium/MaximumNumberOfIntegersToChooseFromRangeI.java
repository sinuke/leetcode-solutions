package com.sinuke.medium;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximumNumberOfIntegersToChooseFromRangeI {

    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = Arrays.stream(banned).boxed().collect(Collectors.toSet());

        int k = 0;
        int i = 1;
        int sum = 0;

        while (i <= n && sum <= maxSum) {
            if (!bannedSet.contains(i)) {
                sum += i;
                if (sum <= maxSum) k++;
            }
            i++;
        }
        return k;
    }

}
