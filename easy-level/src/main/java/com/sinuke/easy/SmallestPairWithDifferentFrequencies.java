package com.sinuke.easy;

public class SmallestPairWithDifferentFrequencies {

    public int[] minDistinctFreqPair(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) freq[num]++;

        int x = 0, y = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] != 0) {
                if (x == 0) x = i;
                else if (freq[i] != freq[x]) {
                    y = i;
                    break;
                }
            }
        }
        return y == 0 ? new int[] {-1, -1} : new int[] {x, y};
    }

}
