package com.sinuke.easy;

public class FindIfDigitGameCanBeWon {

    public boolean canAliceWin(int[] nums) {
        int sumSingle = 0, sumDouble = 0;
        for (int num : nums) {
            if (num > 0 && num < 10) sumSingle += num;
            else sumDouble += num;
        }

        return sumSingle != sumDouble;
    }

}
