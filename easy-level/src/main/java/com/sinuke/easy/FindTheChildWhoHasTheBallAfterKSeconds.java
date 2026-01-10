package com.sinuke.easy;

public class FindTheChildWhoHasTheBallAfterKSeconds {

    public int numberOfChild(int n, int k) {
        if (k < n) return k;
        else if (k % (n - 1) == 0) return (k / (n - 1)) % 2 == 0 ? 0 : n - 1;
        else return (k / (n - 1)) % 2 == 0 ? k % (n - 1) : n - k % (n - 1) - 1;
    }

}
