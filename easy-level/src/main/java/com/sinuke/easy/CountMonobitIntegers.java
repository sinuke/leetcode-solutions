package com.sinuke.easy;

public class CountMonobitIntegers {

    public int countMonobit(int n) {
        int count = 0, p = 1;
        while (p - 1 <= n) {
            p *= 2;
            count++;
        }
        return count;
    }

}
