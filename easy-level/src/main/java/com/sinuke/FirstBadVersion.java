package com.sinuke;

public class FirstBadVersion {

    private final int bad;

    public FirstBadVersion(int n, int bad) {
        this.bad = bad;
    }

    private boolean isBadVersion(int n) {
        return n >= bad;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

}
