package com.sinuke.easy;

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        int peak = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[peak]) peak = i;
        }

        if (peak == 0 || peak == arr.length - 1) return false;


        for (int i = 1; i < arr.length; i++) {
            if (i < peak && arr[i] <= arr[i - 1]) return false;
            else if (i == peak && (arr[i] <= arr[i - 1] || arr[i] <= arr[i + 1])) return false;
            else if (i > peak && arr[i] >= arr[i - 1]) return false;
        }

        return true;
    }

}
