package com.sinuke.medium;

public class FindThePrefixCommonArrayOfTwoArrays {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] counts = new int[n + 1];
        int[] result = new int[n];
        int common = 0;

        for (int i = 0; i < n; i++) {
            if (++counts[A[i]] == 2) common++;
            if (++counts[B[i]] == 2) common++;

            result[i] = common;
        }

        return result;
    }

}
