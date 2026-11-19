package com.sinuke.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DesignFrequencyTracker {

    public static class FrequencyTracker {

        private final int[] nums;
        private final Map<Integer, Set<Integer>> freq;

        public FrequencyTracker() {
            this.nums = new int[100_001];
            this.freq = new HashMap<>(100_001);
        }

        public void add(int number) {
            if (nums[number] != 0) {
                freq.get(nums[number]).remove(number);
                if (freq.get(nums[number]).isEmpty()) freq.remove(nums[number]);
            }

            nums[number]++;
            freq.putIfAbsent(nums[number], new HashSet<>());
            freq.get(nums[number]).add(number);
        }

        public void deleteOne(int number) {
            if (nums[number] != 0) {
                freq.get(nums[number]).remove(number);
                if (freq.get(nums[number]).isEmpty()) freq.remove(nums[number]);

                nums[number]--;

                if (nums[number] != 0) {
                    freq.putIfAbsent(nums[number], new HashSet<>());
                    freq.get(nums[number]).add(number);
                }
            }
        }

        public boolean hasFrequency(int frequency) {
            return freq.containsKey(frequency);
        }
    }

}
