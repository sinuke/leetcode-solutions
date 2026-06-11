package com.sinuke.easy;

public class DistributeCandiesAmongChildrenI {

    public int distributeCandies(int n, int limit) {
        int cnt = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                int k = n - i - j;
                if (k >= 0 && k <= limit) cnt++;
            }
        }
        return cnt;
    }

}
