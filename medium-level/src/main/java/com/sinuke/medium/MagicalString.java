package com.sinuke.medium;

public class MagicalString {

    public int magicalString(int n) {
        byte[] a = new byte[n];
        a[0] = 1;
        if (n > 1) a[1] = 2;
        if (n > 2) a[2] = 2;
        int i = 2, j = 2, cnt = 1;

        while (i < n) {
            if (a[i] == 2 && j < n - 1) {
                byte v = a[j] == 2 ? (byte) 1 : 2;
                a[++j] = v;
                if (j < n - 1) a[++j] = v;
            } else if (a[i] == 1) {
                cnt++;
                if (j < n - 1) {
                    byte v = a[j] == 2 ? (byte) 1 : 2;
                    a[++j] = v;
                }
            }

            i++;
        }
        return cnt;
    }

}
