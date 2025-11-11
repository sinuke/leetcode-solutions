package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CheckIfAnyElementHasPrimeFrequency {

    private final Set<Integer> primes = Set.of(
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
    );

    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(nums.length);
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        for (var entry : freq.entrySet()) {
            if (primes.contains(entry.getValue())) return true;
        }
        return false;
    }

}
