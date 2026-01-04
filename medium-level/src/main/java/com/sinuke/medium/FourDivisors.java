package com.sinuke.medium;

import java.util.HashSet;
import java.util.Set;

public class FourDivisors {

    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) ans += sumOfDivisors(num);
        return ans;
    }

    private int sumOfDivisors(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
                sum += i;
                sum += n / i;
            }

            if (set.size() > 4) return 0;
        }

        return set.size() == 4 ? sum : 0;
    }

}
