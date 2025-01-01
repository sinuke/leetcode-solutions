package com.sinuke.easy;

public class MaximumScoreAfterSplittingString {

    public int maxScore(String s) {
        int[] prefixSum = new int[s.length()];
        prefixSum[s.length() - 1] = s.charAt(s.length() - 1) == '1' ? 1 : 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            prefixSum[i] = prefixSum[i + 1];
            if (s.charAt(i) == '1') prefixSum[i]++;
        }

        int sumZero = s.charAt(0) == '0' ? 1 : 0;
        int score = sumZero + prefixSum[1];
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') sumZero++;
            if (prefixSum[i] + sumZero > score) score = prefixSum[i] + sumZero;
        }

        return score;
    }

}
