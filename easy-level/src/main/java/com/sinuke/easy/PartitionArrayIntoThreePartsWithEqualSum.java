package com.sinuke.easy;

public class PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum1 = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            sum1 += arr[i];
            int sum2 = 0;
            for (int j = i + 1; j < arr.length - 1; j++) {
                sum2 += arr[j];

                if (sum1 == sum2) {
                    int sum3 = 0;
                    for (int k = j + 1; k < arr.length; k++) sum3 += arr[k];
                    if (sum3 == sum1) return true;
                    break;
                }
            }
        }
        return false;
    }

}
