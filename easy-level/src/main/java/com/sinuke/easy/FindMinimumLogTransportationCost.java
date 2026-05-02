package com.sinuke.easy;

public class FindMinimumLogTransportationCost {

    public long minCuttingCost(int n, int m, int k) {
        if (n + m <= k * 3 && n < k && m < k) return 0;

        long c = 0;
        if (n > k && m <= k) c = (long) k * (n - k);
        else if (m > k && n <= k) c = (long) k * (m - k);
        else if (m > k && n > k) c = (long) k * (n - k) + k * (m - k);

        return c;
    }

}
