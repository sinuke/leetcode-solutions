package com.sinuke.easy;

public class CheckIfTheNumberIsFascinating {

    // 1 ms - 95 %
    public boolean isFascinating(int n) {
        int n2 = n * 2, n3 = n * 3;
        int[] nums = new int[10];

        int tmp = 0;
        while (n > 0) {
            tmp = n % 10;
            if (nums[tmp] == 1) return false;
            nums[tmp]++;

            tmp = n2 % 10;
            if (nums[tmp] == 1) return false;
            nums[tmp]++;

            tmp = n3 % 10;
            if (nums[tmp] == 1) return false;
            nums[tmp]++;

            n /= 10;
            n2 /= 10;
            n3 /= 10;
        }

        return nums[0] == 0 && nums[n2 % 10] == 0 && nums[n3 % 10] == 0;
    }

    // 1 ms - 95 %
    public boolean isFascinating2(int n) {
        return n == 192 || n == 219 || n == 273 || n == 327;
    }

    // 5 ms - 52 %
    public boolean isFascinating3(int n) {
        String num = String.valueOf(n) + n * 2 + n * 3;
        int[] nums = new int[10];

        for (char c : num.toCharArray()) {
            n = c - '0';
            if (n == 0 || nums[n] == 1) return false;
            nums[n]++;
        }

        return true;
    }

}
