package com.sinuke.easy;

public class KItemsWithTheMaximumSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;

        if (numOnes >= k) sum = +k;
        else {
            if (numOnes > 0) {
                sum += numOnes;
                k -= numOnes;
            }

            if (numZeros > 0 && k > 0) {
                if (numZeros >= k) k = 0;
                else k -= numZeros;
            }

            if (k > 0) sum += (-1) * k;
        }

        return sum;
    }

}
