package com.sinuke.easy;

public class DuplicateZeros {

    // extra memory
    public void duplicateZeros(int[] arr) {
        int[] tmp = new int[arr.length * 2];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                tmp[j++] = arr[i];
                tmp[j++] = 0;
            } else tmp[j++] = arr[i];

            arr[i] = tmp[i];
        }
    }

}
