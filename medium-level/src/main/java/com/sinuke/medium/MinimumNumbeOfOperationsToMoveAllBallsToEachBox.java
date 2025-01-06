package com.sinuke.medium;

public class MinimumNumbeOfOperationsToMoveAllBallsToEachBox {

    // 63 ms
    public int[] minOperations(String boxes) {
        var chars = boxes.toCharArray();
        var result = new int[chars.length];

        for (var i = 0; i < chars.length; i++) {
            for (var j = 0; j < chars.length; j++) {
                if (chars[j] == '1') result[i] += Math.abs(i - j);
            }
        }

        return result;
    }

    // prefix sum - solution from Leetcode
    // 3 ms
    public int[] minOperations2(String boxes) {
        int n = boxes.length();
        int[] distances = new int[n];

        int prefixCount = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; ++i) {
            distances[i] = prefixCount * i - prefixSum;
            if (boxes.charAt(i) == '1') {
                ++prefixCount;
                prefixSum += i;
            }
        }

        int suffixCount = 0;
        int suffixSum = 0;

        for (int i = n - 1; i >= 0; --i) {
            distances[i] += suffixSum - suffixCount * i;
            if (boxes.charAt(i) == '1') {
                ++suffixCount;
                suffixSum += i;
            }
        }

        return distances;
    }

}
