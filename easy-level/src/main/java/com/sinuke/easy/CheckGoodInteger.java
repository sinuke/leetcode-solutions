package com.sinuke.easy;

public class CheckGoodInteger {

    public boolean checkGoodInteger(int n) {
        long sum = 0L, ssum = 0L;
        while (n > 0) {
            int d = n % 10;
            sum += d;
            ssum += d * d;
            n /= 10;
        }
        return ssum - sum >= 50;
    }

}
