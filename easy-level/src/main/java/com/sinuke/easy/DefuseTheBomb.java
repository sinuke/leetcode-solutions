package com.sinuke.easy;

public class DefuseTheBomb {

    // 4 ms - 7%
    public int[] decrypt2(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 1; j <= Math.abs(k); j++) {
                if (k > 0) sum += code[(i + j) % n];
                else if (k < 0) sum += code[(i + n + ((- j) % n)) % n];
            }
            ans[i] = sum;
        }

        return ans;
    }

    // 0 ms - 100%
    public int[] decrypt(int[] code, int k) {
        int n = code.length, kk = Math.abs(k);
        int[] ans = new int[n];
        if (k == 0) return ans;

        int sum = 0, s = (k > 0) ? 1 : n + k, e = (k > 0) ? k : n - 1;
        for (int i = s; i <= e; i++) {
            sum += code[i % n];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = sum;
            sum = sum - code[(s + i) % n] + code[(e + i + 1) % n];
        }

        return ans;
    }

}
