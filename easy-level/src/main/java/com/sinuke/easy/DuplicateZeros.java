package com.sinuke.easy;

public class DuplicateZeros {

    // extra memory
    public void duplicateZeros(int[] arr) {
        int[] tmp = new int[arr.length * 2];
        int j = 0;
        for (int num : arr) {
            if (num == 0) {
                tmp[j++] = num;
                tmp[j++] = 0;
            } else tmp[j++] = num;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp[i];
        }
    }

}
