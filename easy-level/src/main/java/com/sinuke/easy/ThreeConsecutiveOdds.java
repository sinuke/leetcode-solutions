package com.sinuke.easy;

public class ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 0;

        while (i < arr.length - 2) {
            if (arr[i] % 2 != 0) {
                if (arr[i + 1] % 2 != 0) {
                    if (arr[i + 2] % 2 != 0) return true;
                    else i += 3;
                } else i += 2;
            } else i++;
        }

        return false;
    }

}
