package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {

    public int countLargestGroup(int n) {
        Map<Integer, Integer> counts = new HashMap<>();
        int max = 0, result = 0;

        for (int i = 1; i <= n; i++) {
            int sum = sum(i);
            int count = counts.getOrDefault(sum, 0) + 1;
            counts.put(sum, count);

            if (count > max) {
                max = count;
                result = 1;
            } else if (count == max) result++;
        }

        return result;
    }

    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}
